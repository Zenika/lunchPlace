package com.zenika.lunchPlace.restaurant

import com.zenika.lunchPlace.organization.RestaurantRepository
import com.zenika.lunchPlace.restaurant.category.FoodCategory
import com.zenika.lunchPlace.restaurant.category.PriceCategory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

/**
 * Created by Gwennaël Buchet on 22/10/16.
 */

@RestController
@RequestMapping("/restaurants")
class RestaurantController @Autowired constructor(val repository: RestaurantRepository) {

    @CrossOrigin
    @RequestMapping("/", method = arrayOf(RequestMethod.GET))
    fun findAll(): Iterable<Restaurant> = repository.findAll()

    @CrossOrigin
    @RequestMapping("/{name}", method = arrayOf(RequestMethod.GET))
    fun findByLastName(@PathVariable name: String)
            = repository.findByName(name)

    @CrossOrigin
    @RequestMapping("/add", method = arrayOf(RequestMethod.POST))
    fun add(@RequestParam(value = "name") name: String): Restaurant {

        val restaurant = Restaurant(
                name,
                /*Address(
                        50.636432, 3.062100,
                        6,
                        "rue Jean Roisin",
                        "",
                        "",
                        59000,
                        "Lille",
                        "France",
                        "FR"
                ),*/
                ArrayList<FoodCategory>(),
                PriceCategory.LP_PRICE_STANDARD,
                "")

        repository.save(restaurant)

        return restaurant
    }

}