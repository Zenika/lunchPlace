package com.zenika.lunchPlace.organization

import com.zenika.lunchPlace.restaurant.Restaurant
import java.io.Serializable
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToMany

@Entity
data class Team(val name: String = "",
                @ManyToMany
                val users: List<User> = ArrayList<User>(),
                @ManyToMany
                val preferedRestaurants: List<Restaurant> = ArrayList<Restaurant>(),
                @ManyToMany
                val lastRestaurantsUsed: List<Restaurant> = ArrayList<Restaurant>(),
                @Id @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
                val id: Long = 0) : Serializable
