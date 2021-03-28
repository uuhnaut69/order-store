package com.uuhnaut69.kover.repository

import com.uuhnaut69.kover.model.Restaurant
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface RestaurantRepository : JpaRepository<Restaurant, UUID> {

    @Query(value = "select r from restaurants r left join fetch r.dishes")
    override fun findAll(): List<Restaurant>
}