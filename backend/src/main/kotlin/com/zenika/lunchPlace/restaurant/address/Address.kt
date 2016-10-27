package com.zenika.lunchPlace.restaurant.address

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Address(val latitude: Double?,
                   val longitude: Double?,
                   val number: Int?,
                   val street: String?,
                   val complement1: String?,
                   val complement2: String?,
                   val zipCode: Int?,
                   val city: String?,
                   val country: String = "France",
                   val countryCode: String = "FR",
                   @Id @GeneratedValue(strategy = GenerationType.AUTO)
                   val id: Long = 0)