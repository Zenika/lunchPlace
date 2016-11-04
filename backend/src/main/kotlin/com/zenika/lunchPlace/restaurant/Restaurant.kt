package com.zenika.lunchPlace.restaurant

import com.zenika.lunchPlace.restaurant.address.Address
import com.zenika.lunchPlace.restaurant.category.FoodCategory
import com.zenika.lunchPlace.restaurant.category.PriceCategory
import java.io.Serializable
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Restaurant(val name: String = "",
                      //val address: Address,
                      val foodCategories: ArrayList<FoodCategory> = ArrayList<FoodCategory>(),
                      val priceCategory: PriceCategory = PriceCategory.LP_PRICE_STANDARD,
                      @Id @GeneratedValue(strategy = GenerationType.AUTO)
                      val id: Long = 0) : Serializable