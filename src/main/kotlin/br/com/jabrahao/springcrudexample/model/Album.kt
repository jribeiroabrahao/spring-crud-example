package br.com.jabrahao.springcrudexample.model

import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.*

@Entity
@Table(name = "albums")
class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null

    @ManyToOne
    @JoinColumn(name = "user_id")
    var user: User? = null

    @Column(name = "title")
    var title: String? = null

    @JsonProperty("userId")
    fun setUserId(userId: Int) {
        user = User()
        user!!.id = userId
    }
}