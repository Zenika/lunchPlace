package com.zenika.lunchPlace.organization

import com.zenika.lunchPlace.restaurant.Restaurant
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

/**
 * Created by Gwennaël Buchet on 22/10/16.
 */

@RestController
@RequestMapping("/api/v1/organizations")
class OrganizationController @Autowired constructor(val repository: OrganizationRepository) {

    @CrossOrigin
    @GetMapping(value = "/")
    fun findAll(): Iterable<Organization> = repository.findAll()

    @CrossOrigin
    @GetMapping(value = "/{id}")
    fun findById(@PathVariable id: Long) : Iterable<Organization>
            = repository.findById(id)

    @CrossOrigin
    @PostMapping(value = "/add")
    fun add(@RequestParam(value = "name", defaultValue = "Zenika") name: String): Organization {

        val organization = Organization(name, ArrayList<Team>())

        repository.save(organization)

        return organization
    }

}