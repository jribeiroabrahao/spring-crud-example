package br.com.jabrahao.springcrudexample.model

import javax.persistence.*

@Entity
@Table(name = "users")
class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Int? = null

    @Column(name = "name")
    var name: String? = null

    @Column(name = "username")
    var username: String? = null

    @Column(name = "email")
    var email: String? = null

    @Embedded
    var address: Address? = null

    @Column(name = "phone")
    var phone: String? = null

    @Column(name = "url")
    var website: String? = null

    @Embedded
    var company: Company? = null
}