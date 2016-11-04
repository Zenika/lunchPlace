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
    @RequestMapping("/", method = arrayOf(RequestMethod.GET))
    fun findAll(): Iterable<User> = repository.findAll()

    @RequestMapping("/{name}")
    fun findByNickname(@PathVariable nickname: String)
            = repository.findByNickname(nickname)

    @CrossOrigin
    @RequestMapping("/add", method = arrayOf(RequestMethod.POST))
    fun add(@RequestParam(value = "firstname", defaultValue = "") firstname: String,
            @RequestParam(value = "lastname", defaultValue = "") lastname: String,
            @RequestParam(value = "nickname", defaultValue = "") nickname: String): User {

        val user = User(firstname, lastname, nickname)

        repository.save(user)

        return user
    }

}