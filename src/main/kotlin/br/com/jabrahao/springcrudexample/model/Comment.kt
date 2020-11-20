package br.com.jabrahao.springcrudexample.model

import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.*

@Entity
@Table(name = "comments")
class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null

    @Column(name = "name")
    var name: String? = null

    @Column(name = "email")
    var email: String? = null

    @Column(name = "body", columnDefinition = "TEXT")
    var body: String? = null

    @ManyToOne
    @JoinColumn(name = "post_id")
    var post: Post? = null

    @JsonProperty("postId")
    fun setPostId(postId: Int) {
        post = Post()
        post!!.id = postId
    }
}