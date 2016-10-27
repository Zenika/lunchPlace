package com.zenika.lunchPlace.organization

import com.zenika.lunchPlace.restaurant.Restaurant
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Organization(val name: String = "",
                        val teams: ArrayList<Team> = ArrayList<Team>(),
                        val restaurants: ArrayList<Restaurant> = ArrayList<Restaurant>(),
                        @Id @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
                        val id: Long = 0)
