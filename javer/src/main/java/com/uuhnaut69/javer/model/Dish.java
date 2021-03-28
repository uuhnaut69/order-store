package com.uuhnaut69.javer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "dishes")
public class Dish extends BaseEntity {

  @Column(columnDefinition = "text", nullable = false)
  private String name;

  @Column(nullable = false)
  private BigDecimal price;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  private Restaurant restaurant;
}
