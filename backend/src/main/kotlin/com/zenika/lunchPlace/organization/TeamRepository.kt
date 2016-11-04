package com.zenika.lunchPlace.organization

import org.springframework.data.repository.CrudRepository

/**
 * Created by Gwennael Buchet on 02/11/16.
 */
interface TeamRepository : CrudRepository<Team, Long> {
    fun findById(id: Long): List<Team>

    fun findByName(name: String): List<Team>
}