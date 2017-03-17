package com.zenika.lunchPlace.organization

import org.springframework.data.annotation.Id
import java.io.Serializable

data class Team(val name: String = "",
                val users: MutableList<User> = mutableListOf<User>(),
                val preferredRestaurants: MutableList<PreferredRestaurant> = mutableListOf<PreferredRestaurant>(),
                val usedRestaurants: MutableList<UsedRestaurant> = mutableListOf<UsedRestaurant>(),

                @Id val id: String? = null) : Serializable
