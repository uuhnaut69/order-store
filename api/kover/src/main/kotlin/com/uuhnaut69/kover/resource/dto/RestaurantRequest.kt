package com.uuhnaut69.kover.resource.dto

import javax.validation.constraints.NotBlank

data class RestaurantRequest(@NotBlank val name: String, @NotBlank val address: String)
