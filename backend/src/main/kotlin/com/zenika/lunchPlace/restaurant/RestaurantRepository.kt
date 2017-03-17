package com.zenika.lunchPlace.restaurant

import org.springframework.data.mongodb.repository.MongoRepository

/**
 * Created by gwen on 26/10/16.
 */
interface RestaurantRepository : MongoRepository<Restaurant, Long> {
    fun findById(id: Long): List<Restaurant>

    fun findByName(name: String): List<Restaurant>
}