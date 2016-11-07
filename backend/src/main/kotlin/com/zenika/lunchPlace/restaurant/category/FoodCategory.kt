package com.zenika.lunchPlace.restaurant.category

import java.io.Serializable
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

/**
 * A FoodCategory is like a tag : "Asian", "Chinese", "French", "Fat", "Green", ...
 */
@Entity
data class FoodCategory(val name: String = "",
                        @Id @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO) val id: Long = 0) : Serializable