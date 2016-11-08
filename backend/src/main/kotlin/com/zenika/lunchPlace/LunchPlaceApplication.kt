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
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@SpringBootApplication
@EnableSwagger2
open class LunchPlaceApplication {

    private val log = LoggerFactory.getLogger(LunchPlaceApplication::class.java)

    @Bean
    open fun objectMapperBuilder()
            = Jackson2ObjectMapperBuilder().modulesToInstall(KotlinModule())

    @Bean
    open fun api(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
    }

    private fun apiInfo(): ApiInfo {
        return ApiInfoBuilder()
                .title("LunchPlace API")
                .description("API for LunchPlace applications")
                .license("MIT License")
                .licenseUrl("https://github.com/Zenika/lunchPlace/blob/master/LICENSE")
                .version("1.0")
                .build()
    }

    @Bean
    open fun init(restaurantRepository: RestaurantRepository,
                  foodCategoryRepository: FoodCategoryRepository,
                  teamRepository: TeamRepository,
                  userRepository: UserRepository,
                  preferredRestaurantRepository: PreferredRestaurantRepository,
                  organizationRepository: OrganizationRepository,
                  usedRestaurantRepository: UsedRestaurantRepository
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
            val foodCategoryAmericain = FoodCategory("Americain")
            val foodCategoryRegional = FoodCategory("Regional")
            val foodCategorySalade = FoodCategory("Salade")
            val foodCategoryVegetarien = FoodCategory("Végétarien")
            val foodCategoryCreperie = FoodCategory("Crêperie")
            val foodCategoryPizza = FoodCategory("Pizza")
            val foodCategoryPate = FoodCategory("Pate")
            val foodCategoryItalien = FoodCategory("Italien")
            val foodCategoryMexicain = FoodCategory("Mexicain")
            val foodCategorySandwich = FoodCategory("Sandwich")

            foodCategoryRepository.save(foodCategoryAsiatique)
            foodCategoryRepository.save(foodCategoryChinois)
            foodCategoryRepository.save(foodCategoryJaponais)
            foodCategoryRepository.save(foodCategoryThai)
            foodCategoryRepository.save(foodCategoryFastFood)
            foodCategoryRepository.save(foodCategoryKebab)
            foodCategoryRepository.save(foodCategoryBurger)
            foodCategoryRepository.save(foodCategoryFrancais)
            foodCategoryRepository.save(foodCategoryAmericain)
            foodCategoryRepository.save(foodCategoryRegional)
            foodCategoryRepository.save(foodCategorySalade)
            foodCategoryRepository.save(foodCategoryVegetarien)
            foodCategoryRepository.save(foodCategoryCreperie)
            foodCategoryRepository.save(foodCategoryPizza)
            foodCategoryRepository.save(foodCategoryItalien)
            foodCategoryRepository.save(foodCategoryPate)
            foodCategoryRepository.save(foodCategoryMexicain)
            foodCategoryRepository.save(foodCategorySandwich)

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

            val restaurantLoveItaly = Restaurant(
                    "Love Italy",
                    arrayListOf(foodCategoryItalien, foodCategoryPate, foodCategoryPizza),
                    PriceCategory.LP_PRICE_STANDARD,
                    "http://www.justacote.com/photos_entreprises/love-italy-lille-146349354110.jpg")

            val restaurantMadeInFrance = Restaurant(
                    "Made In France",
                    arrayListOf(foodCategoryFrancais, foodCategoryBurger, foodCategorySandwich),
                    PriceCategory.LP_PRICE_STANDARD,
                    "http://www.le-made-in-france.fr/themes/madein/img/made-in-france.png")

            val restaurantHoneyAndPie = Restaurant(
                    "Honey And Pie",
                    arrayListOf(foodCategoryFrancais, foodCategorySalade, foodCategorySandwich),
                    PriceCategory.LP_PRICE_STANDARD,
                    "http://www.honeyandpie.com/img/diapo/4.jpg")

            val restaurantFreshBurritos = Restaurant(
                    "Fresh Burritos",
                    arrayListOf(foodCategoryMexicain),
                    PriceCategory.LP_PRICE_STANDARD,
                    "http://www.freshburritos.fr/img/header_logo_freshburritos.png")

            val restaurantBigFernand = Restaurant(
                    "Fresh Burritos",
                    arrayListOf(foodCategoryBurger, foodCategoryFrancais),
                    PriceCategory.LP_PRICE_EXPENSIVE,
                    "http://146.185.182.17/wp-content/uploads/2016/07/logo-big-fernand.jpg")

            val restaurantRaptorShack = Restaurant(
                    "Raptor Shack",
                    arrayListOf(foodCategoryBurger, foodCategoryAmericain),
                    PriceCategory.LP_PRICE_STANDARD,
                    "http://www.raptorshack.com/images/Raptorshack/Logo-Raptor-Shack-CMJN.png")

            val restaurantSubway = Restaurant(
                    "Subway",
                    arrayListOf(foodCategoryBurger, foodCategoryFastFood, foodCategoryAmericain),
                    PriceCategory.LP_PRICE_STANDARD,
                    "http://vignette2.wikia.nocookie.net/logopedia/images/e/eb/Subway_new_logo.png/revision/latest?cb=20101219033821")

            restaurantRepository.save(restaurantSoGood)
            restaurantRepository.save(restaurantTokyo)
            restaurantRepository.save(restaurantUnik)
            restaurantRepository.save(restaurantBeaurepaire)
            restaurantRepository.save(restaurantLoveItaly)
            restaurantRepository.save(restaurantMadeInFrance)
            restaurantRepository.save(restaurantHoneyAndPie)
            restaurantRepository.save(restaurantFreshBurritos)
            restaurantRepository.save(restaurantBigFernand)
            restaurantRepository.save(restaurantRaptorShack)
            restaurantRepository.save(restaurantSubway)

            val preferedRestaurant1 = PreferredRestaurant(restaurantSoGood, 6)
            val preferedRestaurant2 = PreferredRestaurant(restaurantTokyo, 7)
            val preferedRestaurant3 = PreferredRestaurant(restaurantUnik, 5)
            val preferedRestaurant4 = PreferredRestaurant(restaurantBeaurepaire, 5)
            val preferedRestaurant5 = PreferredRestaurant(restaurantLoveItaly, 4)
            val preferedRestaurant6 = PreferredRestaurant(restaurantMadeInFrance, 6)
            val preferedRestaurant7 = PreferredRestaurant(restaurantHoneyAndPie, 6)
            val preferedRestaurant8 = PreferredRestaurant(restaurantFreshBurritos, 8)
            val preferedRestaurant9 = PreferredRestaurant(restaurantBigFernand, 6)
            val preferedRestaurant10 = PreferredRestaurant(restaurantRaptorShack, 7)
            val preferedRestaurant11 = PreferredRestaurant(restaurantSubway, 5)

            preferredRestaurantRepository.save(preferedRestaurant1)
            preferredRestaurantRepository.save(preferedRestaurant2)
            preferredRestaurantRepository.save(preferedRestaurant3)
            preferredRestaurantRepository.save(preferedRestaurant4)
            preferredRestaurantRepository.save(preferedRestaurant5)
            preferredRestaurantRepository.save(preferedRestaurant6)
            preferredRestaurantRepository.save(preferedRestaurant7)
            preferredRestaurantRepository.save(preferedRestaurant8)
            preferredRestaurantRepository.save(preferedRestaurant9)
            preferredRestaurantRepository.save(preferedRestaurant10)
            preferredRestaurantRepository.save(preferedRestaurant11)


            val userGwen = User("Gwennaël", "Buchet", "Gwoin")
            val userAurelien = User("Aurélien", "Loyer", "Aurel")
            val userManuD = User("Emmanuel", "Demey", "Manu")
            val userChristophe = User("Christophe", "Furmaniack", "Cricri")

            userRepository.save(userGwen)
            userRepository.save(userAurelien)
            userRepository.save(userManuD)
            userRepository.save(userChristophe)

            val usedRestaurant0: UsedRestaurant = UsedRestaurant(restaurantMadeInFrance, 1478559600000)
            val usedRestaurant1: UsedRestaurant = UsedRestaurant(restaurantSoGood, 1478473200000)
            val usedRestaurant2: UsedRestaurant = UsedRestaurant(restaurantTokyo, 1478214000000)
            val usedRestaurant3: UsedRestaurant = UsedRestaurant(restaurantLoveItaly, 1478127600000)
            usedRestaurantRepository.save(usedRestaurant0)
            usedRestaurantRepository.save(usedRestaurant1)
            usedRestaurantRepository.save(usedRestaurant2)
            usedRestaurantRepository.save(usedRestaurant3)

            val teamBiloute = Team("Les Biloutes",
                    mutableListOf(userGwen, userAurelien, userManuD, userChristophe),
                    mutableListOf(preferedRestaurant1, preferedRestaurant2, preferedRestaurant3,
                            preferedRestaurant4, preferedRestaurant5, preferedRestaurant6,
                            preferedRestaurant7, preferedRestaurant8, preferedRestaurant9,
                            preferedRestaurant10, preferedRestaurant11),
                    mutableListOf(usedRestaurant0, usedRestaurant1, usedRestaurant2, usedRestaurant3))

            teamRepository.save(teamBiloute)

            val organizationZenika = Organization("Zenika", mutableListOf(teamBiloute))
            organizationRepository.save(organizationZenika)

        }
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(LunchPlaceApplication::class.java, *args)
}