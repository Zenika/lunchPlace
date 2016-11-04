package com.zenika.lunchPlace.restaurant.category

import com.zenika.lunchPlace.organization.Organization
import com.zenika.lunchPlace.organization.PreferredRestaurant
import com.zenika.lunchPlace.organization.UsedRestaurant
import org.springframework.data.repository.CrudRepository

/**
 * Created by gwen on 26/10/16.
 */
interface UsedRestaurantRepository : CrudRepository<UsedRestaurant, Long> {
}