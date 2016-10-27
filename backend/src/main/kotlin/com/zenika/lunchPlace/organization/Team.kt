package com.zenika.lunchPlace.organization

import com.zenika.lunchPlace.restaurant.Restaurant
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Team(val name: String = "",
                val users: ArrayList<User>?,
                val lastRestaurantsUsed: ArrayList<Restaurant>?,
                val favoriteRestaurants: ArrayList<Restaurant>?,
                @Id @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
                val id: Long = 0)
