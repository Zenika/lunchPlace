package com.zenika.lunchPlace.organization

import com.zenika.lunchPlace.restaurant.Restaurant
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

/**
 * Created by Gwennaël Buchet on 22/10/16.
 */

@RestController
@RequestMapping("/organizations")
class OrganizationController @Autowired constructor(val repository: OrganizationRepository) {

    @CrossOrigin
    @RequestMapping("/", method = arrayOf(RequestMethod.GET))
    fun findAll(): Iterable<Organization> = repository.findAll()

    @RequestMapping("/{name}")
    fun findByName(@PathVariable name: String)
            = repository.findByName(name)

    @CrossOrigin
    @RequestMapping("/add", method = arrayOf(RequestMethod.POST))
    fun add(@RequestParam(value = "name", defaultValue = "Zenika") name: String): Organization {

        val organization = Organization(name, ArrayList<Team>())

        repository.save(organization)

        return organization
    }

}