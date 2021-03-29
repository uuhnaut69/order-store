package com.uuhnaut69.javer.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uuhnaut69.javer.model.Restaurant;
import com.uuhnaut69.javer.repository.RestaurantRepository;
import com.uuhnaut69.javer.resource.dto.RestaurantRequest;
import com.uuhnaut69.javer.resource.exception.NotFoundException;
import com.uuhnaut69.javer.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

  private final ObjectMapper objectMapper;

  private final RestaurantRepository restaurantRepository;

  @Override
  @Transactional(readOnly = true)
  public List<Restaurant> findAll() {
    return restaurantRepository.findAll();
  }

  @Override
  @Transactional(readOnly = true)
  public Restaurant findById(UUID restaurantId) {
    return restaurantRepository.findById(restaurantId).orElseThrow(NotFoundException::new);
  }

  @Override
  public Restaurant create(RestaurantRequest restaurantRequest) {
    Restaurant restaurant = objectMapper.convertValue(restaurantRequest, Restaurant.class);
    return restaurantRepository.save(restaurant);
  }
}
