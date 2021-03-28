package com.uuhnaut69.kover.resource.dto

import java.math.BigDecimal
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class DishRequest(@NotBlank val name: String, @NotNull val price: BigDecimal)
