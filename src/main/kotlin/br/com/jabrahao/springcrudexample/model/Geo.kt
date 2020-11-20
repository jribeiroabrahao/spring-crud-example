package br.com.jabrahao.springcrudexample.model

import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
class Geo {

    @Column(name = "address_geo_lat")
    var lat: Double? = null

    @Column(name = "address_geo_lng")
    var lng: Double? = null
}