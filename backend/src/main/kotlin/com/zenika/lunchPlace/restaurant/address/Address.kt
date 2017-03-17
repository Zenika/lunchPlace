package com.zenika.lunchPlace.restaurant.address

import org.springframework.data.annotation.Id
import java.io.Serializable

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

                   @Id val id: String? = null) : Serializable