package com.zenika.lunchPlace.organization

import org.springframework.data.repository.CrudRepository

/**
 * Created by Gwennael Buchet on 26/10/16.
 */
interface OrganizationRepository : CrudRepository<Organization, Long> {
    fun findById(id: Long): List<Organization>

    fun findByName(name: String): List<Organization>
}