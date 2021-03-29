package com.uuhnaut69.kover.model

import lombok.Getter
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.sql.Timestamp
import java.util.*
import javax.persistence.*

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
open class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: UUID? = null

    @CreatedDate
    @Column(nullable = false)
    var createdDate: Timestamp? = null

}