package com.zenika.lunchPlace.organization

import com.zenika.lunchPlace.restaurant.Restaurant
import java.io.Serializable
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne

/**
 * Created by gwen.
 * Date: 04/11/16.
 * Time: 14:31.
 *
 */
@Entity
data class PreferredRestaurant(@ManyToOne
                                val restaurant: Restaurant = Restaurant(),
        //global review from the team. Could be negative
                               val teamReview: Int = 0,

                               @Id @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
                               val id: Long = 0) : Serializable

