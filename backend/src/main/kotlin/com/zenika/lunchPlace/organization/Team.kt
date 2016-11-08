package com.zenika.lunchPlace.organization

import java.io.Serializable
import java.util.*
import javax.persistence.*

@Entity
data class Team(val name: String = "",
                @ManyToMany
                val users: MutableList<User> =  mutableListOf<User>(),
                @ManyToMany
                val preferredRestaurants: MutableList<PreferredRestaurant> = mutableListOf<PreferredRestaurant>(),
                @OneToMany
                val usedRestaurants: MutableList<UsedRestaurant> = mutableListOf<UsedRestaurant>(),
                @Id @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
                val id: Long = 0) : Serializable
