package com.zenika.lunchPlace.organization

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

/**
 * Created by Gwennaël Buchet on 02/11/16.
 */

@RestController
@RequestMapping("/users")
class UserController @Autowired constructor(val repository: UserRepository) {

    @CrossOrigin
    @GetMapping(value = "/")
    fun findAll(): Iterable<User> = repository.findAll()

    @CrossOrigin
    @GetMapping(value = "/{id}")
    fun findById(@PathVariable id: Long) : Iterable<User>
            = repository.findById(id)

    @CrossOrigin
    @PostMapping(value = "/add")
    fun add(@RequestParam(value = "firstname", defaultValue = "") firstname: String,
            @RequestParam(value = "lastname", defaultValue = "") lastname: String,
            @RequestParam(value = "nickname", defaultValue = "") nickname: String): User {

        val user = User(firstname, lastname, nickname)

        repository.save(user)

        return user
    }

}