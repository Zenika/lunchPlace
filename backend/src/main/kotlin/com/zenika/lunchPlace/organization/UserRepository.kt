package com.zenika.lunchPlace.organization

import org.springframework.data.repository.CrudRepository

/**
 * Created by Gwennael Buchet on 02/11/16.
 */
interface UserRepository : CrudRepository<User, Long> {
    fun findById(id: Long): List<User>

    fun findByFirstname(firstname: String): List<User>
    fun findByLastname(lastname: String): List<User>
    fun findByFirstnameAndLastname(firstname: String, lastname: String): List<User>

    fun findByNickname(nickname: String): List<User>
}