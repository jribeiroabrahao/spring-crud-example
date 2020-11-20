package br.com.jabrahao.springcrudexample.bootstrap

import br.com.jabrahao.springcrudexample.model.Post
import br.com.jabrahao.springcrudexample.model.User
import br.com.jabrahao.springcrudexample.repository.PostRepository
import br.com.jabrahao.springcrudexample.repository.UserRepository
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import kong.unirest.Unirest
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class DataLoader: CommandLineRunner {

    @Autowired private lateinit var userRepository: UserRepository
    @Autowired private lateinit var postRepository: PostRepository

    private val logger = LoggerFactory.getLogger(this.javaClass)

    override fun run(vararg args: String?) {
        this.loadUsers()
        this.loadPosts()
    }

    fun loadUsers() {
        val response = Unirest
                .get("https://jsonplaceholder.typicode.com/users")
                .asString()

        if (response.status != 200) {
            logger.warn("Response Status: ${response.status}")
            return
        }

        val mapper = ObjectMapper()
        val users: List<User> = mapper.readValue(response.body)

        userRepository.saveAll(users)
    }

    fun loadPosts() {
        val response = Unirest
                .get("https://jsonplaceholder.typicode.com/posts")
                .asString()

        if (response.status != 200) {
            logger.warn("Response Status: ${response.status}")
            return
        }

        val mapper = ObjectMapper()
        val posts: List<Post> = mapper.readValue(response.body)

        postRepository.saveAll(posts)
    }
}