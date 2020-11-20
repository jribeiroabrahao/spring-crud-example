package br.com.jabrahao.springcrudexample.model

import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.JsonIdentityReference
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.ObjectIdGenerators
import javax.persistence.*

@Entity
@Table(name = "posts")
class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null

    @ManyToOne
    @JoinColumn(name = "user_id")
    var user: User? = null

    @Column(name = "title")
    var title: String? = null

    @Column(name = "body", columnDefinition = "TEXT")
    var body: String? = null

    @JsonProperty("userId")
    fun setUserId(userId: Int) {
        user = User()
        user!!.id = userId
    }
}