package com.zenika.lunchPlace.organization

import com.zenika.lunchPlace.restaurant.Restaurant
import com.zenika.lunchPlace.restaurant.category.UsedRestaurantRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.time.LocalTime
import java.time.ZonedDateTime
import java.util.*

/**
 * Created by Gwennaël Buchet on 22/10/16.
 */

@RestController
@RequestMapping("/teams")
class TeamController @Autowired constructor(val repository: TeamRepository, val usedRestaurantRepository: UsedRestaurantRepository) {

    @CrossOrigin
    @RequestMapping("/", method = arrayOf(RequestMethod.GET))
    fun findAll(): Iterable<Team> = repository.findAll()

    @RequestMapping("/{id}")
    fun findById(@PathVariable id: Long)
            = repository.findById(id)

    @CrossOrigin
    @RequestMapping("/add", method = arrayOf(RequestMethod.POST))
    fun add(@RequestParam(value = "name", defaultValue = "Les Biloutes") name: String): Team {

        //by default a team has never eaten to any restaurant
        val team = Team(name, ArrayList<User>(), ArrayList<PreferredRestaurant>(), ArrayList<UsedRestaurant>())

        repository.save(team)

        return team
    }

    @CrossOrigin
    @RequestMapping("/{id}/restaurants", method = arrayOf(RequestMethod.GET))
    fun getRestaurants(@PathVariable id: Long): MutableList<PreferredRestaurant> {
        val team: Team = repository.findById(id)

        return team.preferredRestaurants
    }

    @CrossOrigin
    @RequestMapping("/{id}/history", method = arrayOf(RequestMethod.GET))
    fun getHistory(@PathVariable id: Long): MutableList<UsedRestaurant> {
        val team: Team = repository.findById(id)

        return team.usedRestaurants
    }

    /**
     * @return an array of propositions for a restaurant for current day
     */
    @CrossOrigin
    @RequestMapping("/{id}/dailyRestaurant", method = arrayOf(RequestMethod.GET))
    fun getDailyRestaurant(@PathVariable id: Long): Restaurant {

        val team: Team = repository.findById(id)

        //this is a very basic algo I'm not proud at all about, but this is just an all first working version :
        // - get last entry in the UsedRestaurant list and check its date.
        //  - if this date is today, so there is already a restaurant for today.
        //  - else random one in the list of non-already-used restaurants

        val today: Date = this.getToday()
        var todayRestaurant: Restaurant = Restaurant()
        val nbRestaurants: Int = team.preferredRestaurants.size

        //if there's no restaurant at all, just send back an empty array
        if (team.preferredRestaurants.isEmpty())
            return todayRestaurant

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

                val preferredRestaurant: Restaurant = team.preferredRestaurants[i].restaurant
                val lastUsedIndex: Int = this.getIndexFromLastusedRestaurant(preferredRestaurant, team)

                val score = lastUsedIndex * weight

                if (score > highestScore) {
                    highestScore = score
                    todayRestaurant = preferredRestaurant
                }
            }

        }

        val newUsedRestaurant = UsedRestaurant(todayRestaurant, today)
        usedRestaurantRepository.save(newUsedRestaurant)

        //add it as the list of used restaurants for the team
        team.usedRestaurants.add(0, newUsedRestaurant)
        repository.save(team)

        return todayRestaurant
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

    private fun getToday(): Date {
        return Date.from(ZonedDateTime.now().with(LocalTime.MIN).toInstant())
    }

}