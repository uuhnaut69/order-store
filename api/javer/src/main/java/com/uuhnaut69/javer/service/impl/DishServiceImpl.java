package com.uuhnaut69.javer.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uuhnaut69.javer.model.Dish;
import com.uuhnaut69.javer.repository.DishRepository;
import com.uuhnaut69.javer.resource.dto.DishRequest;
import com.uuhnaut69.javer.resource.exception.NotFoundException;
import com.uuhnaut69.javer.service.DishService;
import com.uuhnaut69.javer.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Slf4j
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
    log.info("Find all dishes by restaurant's id {}", restaurantId);
    return dishRepository.findAllByRestaurantId(restaurantId);
  }

  @Override
  public Dish create(UUID restaurantId, DishRequest dishRequest) {
    log.info("Create dish {} of restaurant {}", dishRequest, restaurantId);
    var restaurant = restaurantService.findById(restaurantId);
    var dish = objectMapper.convertValue(dishRequest, Dish.class);
    dish.setRestaurant(restaurant);
    return dishRepository.save(dish);
  }

  @Override
  public Dish update(UUID restaurantId, UUID dishId, DishRequest dishRequest) {
    log.info("Update dish {} of restaurant {}", dishId, restaurantId);
    var dish = findById(dishId);
    dish.setName(dishRequest.getName());
    dish.setPrice(dishRequest.getPrice());
    return dishRepository.save(dish);
  }

  @Override
  public void delete(UUID restaurantId, UUID dishId) {
    log.info("Delete dish {} of restaurant {}", dishId, restaurantId);
    dishRepository.deleteById(dishId);
  }

  private Dish findById(UUID dishId) {
    return dishRepository.findById(dishId).orElseThrow(NotFoundException::new);
  }
}
