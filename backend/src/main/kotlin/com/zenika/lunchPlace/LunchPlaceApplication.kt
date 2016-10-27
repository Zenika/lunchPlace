package com.zenika.lunchPlace

import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.zenika.lunchPlace.organization.RestaurantRepository
import com.zenika.lunchPlace.restaurant.Restaurant
import com.zenika.lunchPlace.restaurant.address.Address
import com.zenika.lunchPlace.restaurant.category.FoodCategory
import com.zenika.lunchPlace.restaurant.category.PriceCategory
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder
import java.util.*

@SpringBootApplication
open class LunchPlaceApplication {

    private val log = LoggerFactory.getLogger(LunchPlaceApplication::class.java)

    @Bean
    open fun objectMapperBuilder()
            = Jackson2ObjectMapperBuilder().modulesToInstall(KotlinModule())

    @Bean
    open fun init(repository: RestaurantRepository): CommandLineRunner {
        return CommandLineRunner {
            val restaurant = Restaurant(
                    "Chez Zenika Lille",
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
                    PriceCategory.STANDARD)

            repository.save(restaurant)


            // fetch all restaurants
            log.info("Restaurants found with findAll():")
            for (restaurant in repository.findAll()) {
                log.info(restaurant.toString())
            }
            log.info("")
        }
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(LunchPlaceApplication::class.java, *args)
}
