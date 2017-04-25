package com.zenika.lunchPlace.restaurant

import com.zenika.lunchPlace.restaurant.category.FoodCategory
import com.zenika.lunchPlace.restaurant.category.PriceCategory
import org.springframework.data.annotation.Id
import java.io.Serializable
import java.util.*

data class Restaurant(val name: String = "",
        //val address: Address,
                      val foodCategories: ArrayList<FoodCategory> = ArrayList<FoodCategory>(),
                      val priceCategory: PriceCategory = PriceCategory.LP_PRICE_STANDARD,
                      val imageURL: String = "",

                      @Id val id: String? = null) : Serializable