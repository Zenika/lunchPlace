package com.zenika.lunchPlace.organization

import com.zenika.lunchPlace.restaurant.Restaurant
import org.springframework.data.annotation.Id
import java.io.Serializable

/**
 * Created by gwen.
 * Date: 04/11/16.
 * Time: 14:31.
 *
 * Purpose: An UsedRestaurant is a couple Restaurant/Date used by a team
 */
data class UsedRestaurant(
        val restaurant: Restaurant = Restaurant(),
        val timestamp: Long = 0,

        @Id val id: String? = null) : Serializable

