package com.zenika.lunchPlace.organization

import com.zenika.lunchPlace.restaurant.Restaurant
import org.springframework.data.annotation.Id
import java.io.Serializable

/**
 * Created by gwen.
 * Date: 04/11/16.
 * Time: 14:31.
 *
 */
data class PreferredRestaurant(//@ManyToOne
        val restaurant: Restaurant = Restaurant(),
        //global review from the team. Could be negative
        val teamReview: Int = 0,


        @Id val id: String? = null) : Serializable

