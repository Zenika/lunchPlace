package com.zenika.lunchPlace.organization

import com.zenika.lunchPlace.restaurant.Restaurant
import org.springframework.data.repository.CrudRepository

/**
 * Created by gwen on 26/10/16.
 */
interface RestaurantRepository : CrudRepository<Restaurant, Long> {
    fun findById(id: Long): List<Restaurant>

    fun findByName(name: String): List<Restaurant>
}