package com.uuhnaut69.javer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "restaurants")
public class Restaurant extends BaseEntity {

  private String name;

  private String address;

  @OneToMany(mappedBy = "restaurant", orphanRemoval = true, cascade = CascadeType.ALL)
  private Set<Dish> dishes = new HashSet<>();
}
