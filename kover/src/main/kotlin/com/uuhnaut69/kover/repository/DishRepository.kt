package com.uuhnaut69.kover.repository

import com.uuhnaut69.kover.model.Dish
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface DishRepository : JpaRepository<Dish, UUID> {

    @EntityGraph(attributePaths = ["restaurant"])
    fun findAllByRestaurantId(restaurantId: UUID): List<Dish>
}