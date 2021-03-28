package com.uuhnaut69.javer.resource;

import com.uuhnaut69.javer.model.Dish;
import com.uuhnaut69.javer.model.Restaurant;
import com.uuhnaut69.javer.resource.dto.DishRequest;
import com.uuhnaut69.javer.resource.dto.RestaurantRequest;
import com.uuhnaut69.javer.service.DishService;
import com.uuhnaut69.javer.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/restaurants")
public class RestaurantResource {

  private final DishService dishService;

  private final RestaurantService restaurantService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Restaurant create(@RequestBody @Valid RestaurantRequest restaurantRequest) {
    return restaurantService.create(restaurantRequest);
  }

  @GetMapping
  public List<Restaurant> findAll() {
    return restaurantService.findAll();
  }

  @PostMapping("/{restaurantId}")
  @ResponseStatus(HttpStatus.CREATED)
  public Dish create(@PathVariable UUID restaurantId, @RequestBody @Valid DishRequest dishRequest) {
    return dishService.create(restaurantId, dishRequest);
  }

  @GetMapping("/{restaurantId}")
  public List<Dish> findAllByRestaurantId(@PathVariable UUID restaurantId) {
    return dishService.findAllByRestaurantId(restaurantId);
  }
}
