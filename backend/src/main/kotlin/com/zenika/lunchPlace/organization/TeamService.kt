package com.zenika.lunchPlace.organization

import com.zenika.lunchPlace.restaurant.Restaurant
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.time.LocalTime
import java.time.ZonedDateTime
import java.util.*

/**
 * Created by gwen.
 * Date: 07/11/16.
 * Time: 13:40.
 *
 * Purpose:
 */
@Component
open class TeamService @Autowired constructor(val teamRepository: TeamRepository,
                                              val usedRestaurantRepository: UsedRestaurantRepository) {

    /**
     * @return The UsedRestaurant for Today. If no one was already chosen so get a new one by calling suggestNewDailyRestaurant function
     */
    fun getDailyRestaurant(team: Team): UsedRestaurant? {

        val todayTimestamp: Long = this.getTodayTimestamp()

        var todayUsedRestaurant: UsedRestaurant? = null

        //if a restaurant has already been found for today, just pick it
        if (team.usedRestaurants.isNotEmpty()) {
            val lastUsedRestaurant: UsedRestaurant = team.usedRestaurants[0]
            todayUsedRestaurant = if (lastUsedRestaurant.timestamp == todayTimestamp) lastUsedRestaurant else null
        }

        //else, if no restaurant is already chosen for today, run the wonderful algo (hm hmm...)
        if (null == todayUsedRestaurant) {
            val restaurant = suggestNewDailyRestaurant(team)
            todayUsedRestaurant = UsedRestaurant(restaurant!!, todayTimestamp)

            //save this restaurant as the one for today, so it'll be re-propose next time in the same current day
            usedRestaurantRepository.save(todayUsedRestaurant)

            //add it as the list of used restaurants for the team
            team.usedRestaurants.add(0, todayUsedRestaurant)
            teamRepository.save(team)
        }

        return todayUsedRestaurant
    }

    /**
     *
     * @param team
     * @return a Restaurant for the team.
     * It's only based on history of used restaurants.
     */
    fun suggestNewDailyRestaurant(team: Team): Restaurant? {
        //this is a very basic algo I'm not very proud about (it's not even based on dates), but this is just an all first working version :
        // - get last entry in the UsedRestaurant list and check its date.
        //  - if this date is today, so there is already a restaurant for today.
        //  - else random one in the list of non-already-used restaurants, using a weight for each of them

        var todayRestaurant: Restaurant = Restaurant()
        val nbRestaurants: Int = team.preferredRestaurants.size

        //if there's no restaurant at all, just send back an empty one
        if (team.preferredRestaurants.isEmpty())
            return null

        //if there's no used restaurant : easy, just pick a new one
        if (team.usedRestaurants.isEmpty()) {
            val choosenRestaurantIndex: Int = (Math.random() * nbRestaurants).toInt()

            todayRestaurant = team.preferredRestaurants[choosenRestaurantIndex].restaurant
        }
        //else use a basic algorithm :
        //each restaurant has a review, from 0 to n.
        //use this review as a weight to choose one
        else {
            var highestScore: Int = -1

            // for each preferred restaurant, try to estimate a weight based on its user review
            for (i in team.preferredRestaurants.indices) {

                var weight = team.preferredRestaurants[i].teamReview
                //add some random to its review in order to avoid getting same order as last week
                weight += (Math.random() * nbRestaurants).toInt()

                //Get the number of days since the team lunched at this restaurant :
                // this is the index in the usedRestaurants array.
                //This index is then multiply with the weight to offer a more accurate weight
                val preferredRestaurant: Restaurant = team.preferredRestaurants[i].restaurant
                val lastUsedIndex: Int = this.getIndexFromLastusedRestaurant(preferredRestaurant, team)

                val score = lastUsedIndex * weight

                if (score > highestScore) {
                    highestScore = score
                    todayRestaurant = preferredRestaurant
                }
            }
        }

        return todayRestaurant
    }


    private fun getTodayTimestamp(): Long {
        return Date.from(ZonedDateTime.now().with(LocalTime.MIN).toInstant()).time
    }


    /**
     * @return index of first occurence of the restaurant in the used restaurant for the team,
     *         ie : index of the most recent time team lunched at it.
     *         If no occurence is found, that menas the team has never lunched here yet. So give it a high score
     */
    private fun getIndexFromLastusedRestaurant(restaurant: Restaurant, team: Team): Int {
        var index = 100000

        for (i in team.usedRestaurants.indices) {
            val r: Restaurant = team.usedRestaurants[i].restaurant
            if (restaurant == r) {
                index = i
                break
            }

        }

        return index
    }
}