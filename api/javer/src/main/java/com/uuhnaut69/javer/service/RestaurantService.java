package com.uuhnaut69.javer.service;

import com.uuhnaut69.javer.model.Dish;
import com.uuhnaut69.javer.model.Restaurant;
import com.uuhnaut69.javer.resource.dto.DishRequest;
import com.uuhnaut69.javer.resource.dto.RestaurantRequest;

import java.util.List;
import java.util.UUID;

public interface RestaurantService {

  List<Restaurant> findAll();

  Restaurant findById(UUID restaurantId);

  Restaurant create(RestaurantRequest restaurantRequest);
}
