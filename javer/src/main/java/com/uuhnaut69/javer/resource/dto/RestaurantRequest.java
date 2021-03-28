package com.uuhnaut69.javer.resource.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantRequest {

  @NotBlank private String name;

  @NotBlank private String address;
}
