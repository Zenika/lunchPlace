package com.zenika.lunchPlace.restaurant.category

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.io.Serializable

/**
 * A FoodCategory is like a tag : "Asian", "Chinese", "French", "Fat", "Green", ...
 */
@Document(collection = "foodCategory")
data class FoodCategory(
        val name: String = "",
        @Id val id: String? = null
) : Serializable