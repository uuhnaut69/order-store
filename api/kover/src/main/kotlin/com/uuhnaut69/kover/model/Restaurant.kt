package com.uuhnaut69.kover.model

import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.OneToMany

@Entity(name = "restaurants")
class Restaurant : BaseEntity() {

    @Column(columnDefinition = "text", nullable = false)
    var name: String? = null

    @Column(columnDefinition = "text", nullable = false)
    var address: String? = null

    @OneToMany(mappedBy = "restaurant", orphanRemoval = true, cascade = [CascadeType.ALL])
    var dishes: Set<Dish>? = null
}