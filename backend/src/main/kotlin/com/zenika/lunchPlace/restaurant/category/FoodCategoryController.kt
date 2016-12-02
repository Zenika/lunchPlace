package com.zenika.lunchPlace.restaurant.category

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

/**
 * Created by Gwennaël Buchet on 22/10/16.
 */

@RestController
@RequestMapping("/foodCategories")
class FoodCategoryController @Autowired constructor(val repository: FoodCategoryRepository) {

    @CrossOrigin
    @RequestMapping("/", method = arrayOf(RequestMethod.GET))
    fun findAll(): Iterable<FoodCategory> = repository.findAll()

    @CrossOrigin
    @RequestMapping("/{id}", method = arrayOf(RequestMethod.GET))
    fun findById(@PathVariable id: Long) : Iterable<FoodCategory>
            = repository.findById(id)

    @CrossOrigin
    @RequestMapping("/add", method = arrayOf(RequestMethod.POST))
    fun add(@RequestParam(value = "name") name: String): FoodCategory {

        val foodCategory = FoodCategory(name)

        repository.save(foodCategory)

        return foodCategory
    }

}