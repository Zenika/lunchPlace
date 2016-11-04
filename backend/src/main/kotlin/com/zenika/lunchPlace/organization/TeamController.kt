package com.zenika.lunchPlace.organization

import com.zenika.lunchPlace.restaurant.Restaurant
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

/**
 * Created by Gwennaël Buchet on 22/10/16.
 */

@RestController
@RequestMapping("/teams")
class TeamController @Autowired constructor(val repository: TeamRepository) {

    @CrossOrigin
    @RequestMapping("/", method = arrayOf(RequestMethod.GET))
    fun findAll(): Iterable<Team> = repository.findAll()

    @RequestMapping("/{name}")
    fun findByName(@PathVariable name: String)
            = repository.findByName(name)

    @CrossOrigin
    @RequestMapping("/add", method = arrayOf(RequestMethod.POST))
    fun add(@RequestParam(value = "name", defaultValue = "Les Biloutes") name: String): Team {

        //by default a team has never eaten to any restaurant
        val team = Team(name, ArrayList<User>(), ArrayList<Restaurant>(), ArrayList<Restaurant>())

        repository.save(team)

        return team
    }

}