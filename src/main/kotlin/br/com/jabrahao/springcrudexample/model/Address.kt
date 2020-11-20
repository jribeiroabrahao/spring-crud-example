package br.com.jabrahao.springcrudexample.model

import javax.persistence.Column
import javax.persistence.Embeddable
import javax.persistence.Embedded

@Embeddable
class Address {

    @Column(name = "address_street")
    var street: String? = null

    @Column(name = "address_suite")
    var suite: String? = null

    @Column(name = "address_city")
    var city: String? = null

    @Column(name = "address_zipcode")
    var zipcode: String? = null

    @Embedded
    var geo: Geo? = null
}
