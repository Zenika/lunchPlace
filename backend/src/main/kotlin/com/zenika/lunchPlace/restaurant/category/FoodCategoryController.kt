package com.zenika.lunchPlace.restaurant.category

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

/**
 * Created by Gwennaël Buchet on 22/10/16.
 */

@RestController
@RequestMapping("/api/v1/foodCategories")
class FoodCategoryController @Autowired constructor(val repository: FoodCategoryRepository) {

    @CrossOrigin
    @GetMapping(value = "/")
    fun findAll(): Iterable<FoodCategory> = repository.findAll()

    @CrossOrigin
    @GetMapping(value = "/{id}")
    fun findById(@PathVariable id: Long) : Iterable<FoodCategory>
            = repository.findById(id)

    @CrossOrigin
    @PostMapping(value = "/add")
    fun add(@RequestParam(value = "name") name: String): FoodCategory {

        val foodCategory = FoodCategory(name)

        repository.save(foodCategory)

        return foodCategory
    }

}