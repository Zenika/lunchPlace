package com.zenika.lunchPlace.organization

import com.zenika.lunchPlace.restaurant.Restaurant
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

/**
 * Created by Gwennaël Buchet on 22/10/16.
 */

@RestController
@RequestMapping("/teams")
class TeamController @Autowired constructor(val repository: TeamRepository,
                                            val teamService: TeamService) {

    @CrossOrigin
    @RequestMapping("/", method = arrayOf(RequestMethod.GET))
    fun findAll(): Iterable<Team> = repository.findAll()

    @CrossOrigin
    @RequestMapping("/{id}", method = arrayOf(RequestMethod.GET))
    fun findById(@PathVariable id: Long) : Team
            = repository.findById(id)

    @CrossOrigin
    @RequestMapping("/add", method = arrayOf(RequestMethod.POST))
    fun add(@RequestParam(value = "name", defaultValue = "Les Biloutes") name: String): ResponseEntity<Team> {

        //by default a team has never eaten to any restaurant
        val team = Team(name, ArrayList<User>(), ArrayList<PreferredRestaurant>(), ArrayList<UsedRestaurant>())

        repository.save(team)

        return ResponseEntity(team, HttpStatus.OK)
    }

    @CrossOrigin
    @RequestMapping("/{id}/restaurants", method = arrayOf(RequestMethod.GET))
    fun getRestaurants(@PathVariable id: Long): ResponseEntity<MutableList<PreferredRestaurant>> {
        val team: Team = repository.findById(id)

        if (Objects.isNull(team))
            return ResponseEntity(null, HttpStatus.NOT_FOUND)

        return ResponseEntity(team.preferredRestaurants, HttpStatus.OK)
    }


    @CrossOrigin
    @RequestMapping("/{id}/history", method = arrayOf(RequestMethod.GET))
    fun getHistory(@PathVariable id: Long): ResponseEntity<MutableList<UsedRestaurant>> {
        val team: Team = repository.findById(id)

        if (Objects.isNull(team))
            return ResponseEntity(null, HttpStatus.NOT_FOUND)

        return ResponseEntity(team.usedRestaurants, HttpStatus.OK)
    }

    /**
     * @return an array of propositions for a restaurant for current day
     */
    @CrossOrigin
    @RequestMapping("/{id}/dailyRestaurant", method = arrayOf(RequestMethod.GET))
    fun getDailyRestaurant(@PathVariable id: Long): ResponseEntity<Restaurant> {

        val team: Team = repository.findById(id)
        //a "non-existing" team won't eat at restaurant :)
        if (Objects.isNull(team))
            return ResponseEntity(null, HttpStatus.NOT_FOUND)

        //try to get a restaurant for today
        val todayUsedRestaurant: UsedRestaurant = teamService.getDailyRestaurant(team)!!
        if (Objects.isNull(todayUsedRestaurant))
            return ResponseEntity(null, HttpStatus.NOT_FOUND)

        return ResponseEntity(todayUsedRestaurant.restaurant, HttpStatus.OK)
    }
}