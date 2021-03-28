package com.uuhnaut69.kover.model

import com.fasterxml.jackson.annotation.JsonIgnore
import java.math.BigDecimal
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.ManyToOne

@Entity(name = "dishes")
class Dish : BaseEntity() {

    @Column(columnDefinition = "text", nullable = false)
    var name: String? = null

    @Column(nullable = false)
    var price: BigDecimal? = null

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    var restaurant: Restaurant? = null

}