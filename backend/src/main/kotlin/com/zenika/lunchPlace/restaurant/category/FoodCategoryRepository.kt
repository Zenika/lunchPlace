package com.zenika.lunchPlace.restaurant.category

import com.zenika.lunchPlace.organization.Organization
import org.springframework.data.repository.CrudRepository

/**
 * Created by gwen on 26/10/16.
 */
interface FoodCategoryRepository : CrudRepository<FoodCategory, Long> {
    fun findByName(name: String): List<FoodCategory>

    fun findById(id: Long): List<FoodCategory>
}