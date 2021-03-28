package com.uuhnaut69.javer.service;

import com.uuhnaut69.javer.model.Dish;
import com.uuhnaut69.javer.resource.dto.DishRequest;

import java.util.List;
import java.util.UUID;

public interface DishService {

  List<Dish> findAllByRestaurantId(UUID restaurantId);

  Dish create(UUID restaurantId, DishRequest dishRequest);
}
