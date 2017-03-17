package com.zenika.lunchPlace.organization

import org.springframework.data.repository.CrudRepository

/**
 * Created by gwen on 26/10/16.
 */
interface UsedRestaurantRepository : CrudRepository<UsedRestaurant, Long> {
}