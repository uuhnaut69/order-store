package com.uuhnaut69.javer.repository;

import com.uuhnaut69.javer.model.Dish;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DishRepository extends JpaRepository<Dish, UUID> {

  @EntityGraph(attributePaths = {"restaurant"})
  List<Dish> findAllByRestaurantId(UUID restaurantId);
}
