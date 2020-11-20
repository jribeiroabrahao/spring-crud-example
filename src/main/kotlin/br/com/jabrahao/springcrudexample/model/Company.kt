package br.com.jabrahao.springcrudexample.model

import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
class Company {

    @Column(name = "company_name")
    var name: String? = null

    @Column(name = "company_catch_phrase")
    var catchPhrase: String? = null

    @Column(name = "bs")
    var bs: String? = null
}
