package com.uuhnaut69.javer.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uuhnaut69.javer.model.Dish;
import com.uuhnaut69.javer.model.Restaurant;
import com.uuhnaut69.javer.repository.DishRepository;
import com.uuhnaut69.javer.resource.dto.DishRequest;
import com.uuhnaut69.javer.service.DishService;
import com.uuhnaut69.javer.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class DishServiceImpl implements DishService {

  private final ObjectMapper objectMapper;

  private final DishRepository dishRepository;

  private final RestaurantService restaurantService;

  @Override
  @Transactional(readOnly = true)
  public List<Dish> findAllByRestaurantId(UUID restaurantId) {
    return dishRepository.findAllByRestaurantId(restaurantId);
  }

  @Override
  public Dish create(UUID restaurantId, DishRequest dishRequest) {
    Restaurant restaurant = restaurantService.findById(restaurantId);
    Dish dish = objectMapper.convertValue(dishRequest, Dish.class);
    dish.setRestaurant(restaurant);
    return dishRepository.save(dish);
  }
}
