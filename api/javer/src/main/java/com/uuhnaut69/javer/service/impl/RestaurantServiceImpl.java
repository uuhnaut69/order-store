package com.uuhnaut69.javer.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uuhnaut69.javer.model.Restaurant;
import com.uuhnaut69.javer.repository.RestaurantRepository;
import com.uuhnaut69.javer.resource.dto.RestaurantRequest;
import com.uuhnaut69.javer.resource.exception.NotFoundException;
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
public class RestaurantServiceImpl implements RestaurantService {

  private final ObjectMapper objectMapper;

  private final RestaurantRepository restaurantRepository;

  @Override
  @Transactional(readOnly = true)
  public List<Restaurant> findAll() {
    log.info("Find all restaurants");
    return restaurantRepository.findAll();
  }

  @Override
  @Transactional(readOnly = true)
  public Restaurant findById(UUID restaurantId) {
    log.info("Find restaurant {}", restaurantId);
    return restaurantRepository.findById(restaurantId).orElseThrow(NotFoundException::new);
  }

  @Override
  public Restaurant create(RestaurantRequest restaurantRequest) {
    log.info("Create restaurant {}", restaurantRequest);
    var restaurant = objectMapper.convertValue(restaurantRequest, Restaurant.class);
    return restaurantRepository.save(restaurant);
  }

  @Override
  public Restaurant update(UUID restaurantId, RestaurantRequest restaurantRequest) {
    var restaurant = findById(restaurantId);
    restaurant.setName(restaurantRequest.getName());
    restaurant.setAddress(restaurantRequest.getAddress());
    return restaurantRepository.save(restaurant);
  }

  @Override
  public void delete(UUID restaurantId) {
    restaurantRepository.deleteById(restaurantId);
  }
}
