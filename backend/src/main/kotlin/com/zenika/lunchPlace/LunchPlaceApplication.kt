package com.zenika.lunchPlace

import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.zenika.lunchPlace.organization.*
import com.zenika.lunchPlace.restaurant.Restaurant
import com.zenika.lunchPlace.restaurant.category.*
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
    open fun init(restaurantRepository: RestaurantRepository,
                  foodCategoryRepository: FoodCategoryRepository,
                  teamRepository: TeamRepository,
                  userRepository: UserRepository,
                  preferredRestaurantRepository: PreferredRestaurantRepository
    ): CommandLineRunner {
        return CommandLineRunner {

            val foodCategoryAsiatique = FoodCategory("Asiatique")
            val foodCategoryChinois = FoodCategory("Chinois")
            val foodCategoryJaponais = FoodCategory("Japonais")
            val foodCategoryThai = FoodCategory("Thaï")
            val foodCategoryFastFood = FoodCategory("FastFood")
            val foodCategoryKebab = FoodCategory("Kebab")
            val foodCategoryBurger = FoodCategory("Burger")
            val foodCategoryFrancais = FoodCategory("Français")
            val foodCategoryRegional = FoodCategory("Regional")
            val foodCategorySalade = FoodCategory("Salade")
            val foodCategoryVegetarien = FoodCategory("Végétarien")
            val foodCategoryCreperie = FoodCategory("Crêperie")
            val foodCategoryPizza = FoodCategory("Pizza")
            val foodCategoryPate = FoodCategory("Pate")
            val foodCategoryItalien = FoodCategory("Italien")
            val foodCategoryMexicain = FoodCategory("Mexicain")

            foodCategoryRepository.save(foodCategoryAsiatique)
            foodCategoryRepository.save(foodCategoryChinois)
            foodCategoryRepository.save(foodCategoryJaponais)
            foodCategoryRepository.save(foodCategoryThai)
            foodCategoryRepository.save(foodCategoryFastFood)
            foodCategoryRepository.save(foodCategoryKebab)
            foodCategoryRepository.save(foodCategoryBurger)
            foodCategoryRepository.save(foodCategoryFrancais)
            foodCategoryRepository.save(foodCategoryRegional)
            foodCategoryRepository.save(foodCategorySalade)
            foodCategoryRepository.save(foodCategoryVegetarien)
            foodCategoryRepository.save(foodCategoryCreperie)
            foodCategoryRepository.save(foodCategoryPizza)
            foodCategoryRepository.save(foodCategoryItalien)
            foodCategoryRepository.save(foodCategoryPate)
            foodCategoryRepository.save(foodCategoryMexicain)

            val restaurantZNK = Restaurant(
                    "Chez Zenika Lille",
                    arrayListOf(foodCategoryPizza, foodCategoryItalien, foodCategoryAsiatique, foodCategoryJaponais),
                    PriceCategory.LP_PRICE_FREE,
                    "https://www.zenika.com/images/logo/Logo_arrondi_Horizontal.png")

            val restaurantSoGood = Restaurant(
                    "So Good",
                    arrayListOf(foodCategorySalade, foodCategoryPate, foodCategoryBurger),
                    PriceCategory.LP_PRICE_CHEAP,
                    "http://www.sogood.fr/img/sogood-1463996559.jpg")

            val restaurantTokyo = Restaurant(
                    "Tokyo",
                    arrayListOf(foodCategoryAsiatique, foodCategoryJaponais),
                    PriceCategory.LP_PRICE_STANDARD,
                    "http://www.tokyo-lille.fr/images/logo.png")

            val restaurantUnik = Restaurant(
                    "Unik",
                    arrayListOf(foodCategoryKebab),
                    PriceCategory.LP_PRICE_STANDARD,
                    "http://www.unik-kebab.fr/img/unik-kebab-1426169913.jpg")

            val restaurantBeaurepaire = Restaurant(
                    "Beaurepaire",
                    arrayListOf(foodCategoryCreperie),
                    PriceCategory.LP_PRICE_STANDARD,
                    "http://www.creperiebeaurepaire.com/upl/website/home/VieuxLille100_srcset-large.jpg")

            restaurantRepository.save(restaurantZNK)
            restaurantRepository.save(restaurantSoGood)
            restaurantRepository.save(restaurantTokyo)
            restaurantRepository.save(restaurantUnik)
            restaurantRepository.save(restaurantBeaurepaire)

            val preferedRestaurant1 = PreferredRestaurant(restaurantSoGood, 10)
            val preferedRestaurant2 = PreferredRestaurant(restaurantTokyo, 5)
            val preferedRestaurant3 = PreferredRestaurant(restaurantUnik, 4)
            val preferedRestaurant4 = PreferredRestaurant(restaurantBeaurepaire, 2)
            val preferedRestaurant5 = PreferredRestaurant(restaurantZNK, 1)

            preferredRestaurantRepository.save(preferedRestaurant1)
            preferredRestaurantRepository.save(preferedRestaurant2)
            preferredRestaurantRepository.save(preferedRestaurant3)
            preferredRestaurantRepository.save(preferedRestaurant4)
            preferredRestaurantRepository.save(preferedRestaurant5)


            val userGwen = User("Gwennaël", "Buchet", "Gwoin")
            val userAurelien = User("Aurélien", "Loyer", "Aurel")
            val userManuD = User("Emmanuel", "Demey", "Manu")
            val userChristophe = User("Christophe", "Furmaniack", "Cricri")

            userRepository.save(userGwen)
            userRepository.save(userAurelien)
            userRepository.save(userManuD)
            userRepository.save(userChristophe)


            val teamBiloute = Team("Les Biloutes",
                    arrayListOf(userGwen, userAurelien, userManuD, userChristophe),
                    arrayListOf(preferedRestaurant1, preferedRestaurant2, preferedRestaurant3, preferedRestaurant4, preferedRestaurant5),
                    ArrayList<UsedRestaurant>())

            teamRepository.save(teamBiloute)
        }
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(LunchPlaceApplication::class.java, *args)
}