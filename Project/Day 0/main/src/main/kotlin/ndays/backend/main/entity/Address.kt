package ndays.backend.main.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.OneToOne
import jakarta.persistence.Table


@Entity
@Table(name = "address")
data class Address(

    @Id
    val id: String,

    var city: String,

    @Column(name = "postcode")
    var postCode:String,

)
