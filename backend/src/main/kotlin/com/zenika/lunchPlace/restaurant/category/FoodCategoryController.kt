package com.zenika.lunchPlace.restaurant.category

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

/**
 * Created by Gwennaël Buchet on 22/10/16.
 */

@RestController
@RequestMapping("/foodCategory")
class FoodCategoryController @Autowired constructor(val repository: FoodCategoryRepository) {

    @CrossOrigin
    @RequestMapping("/", method = arrayOf(RequestMethod.GET))
    fun findAll(): Iterable<FoodCategory> = repository.findAll()

    @RequestMapping("/{name}")
    fun findByLastName(@PathVariable name: String)
            = repository.findByName(name)

    @CrossOrigin
    @RequestMapping("/add", method = arrayOf(RequestMethod.POST))
    fun add(@RequestParam(value = "name") name: String): FoodCategory {

        val foodCategory = FoodCategory(name)

        repository.save(foodCategory)

        return foodCategory
    }

}