package br.com.jabrahao.springcrudexample.bootstrap

import br.com.jabrahao.springcrudexample.model.*
import br.com.jabrahao.springcrudexample.repository.*
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
    @Autowired private lateinit var commentRepository: CommentRepository
    @Autowired private lateinit var albumRepository: AlbumRepository
    @Autowired private lateinit var photoRepository: PhotoRepository

    private val logger = LoggerFactory.getLogger(this.javaClass)

    override fun run(vararg args: String?) {
        this.loadUsers()
        this.loadPosts()
        this.loadComments()
        this.loadAlbums()
        this.loadPhotos()
    }

    fun loadData(path: String): String? {
        val response = Unirest
                .get("https://jsonplaceholder.typicode.com/$path")
                .asString()

        if (response.status != 200) {
            logger.warn("Response Status: ${response.status}")
            return null
        }

        return response.body
    }

    fun loadUsers() {

        val json = loadData("users") ?: return
        val mapper = ObjectMapper()
        val users: List<User> = mapper.readValue(json)

        userRepository.saveAll(users)
    }

    fun loadPosts() {

        val json = loadData("posts") ?: return
        val mapper = ObjectMapper()
        val posts: List<Post> = mapper.readValue(json)

        postRepository.saveAll(posts)
    }

    fun loadComments() {

        val json = loadData("comments") ?: return
        val mapper = ObjectMapper()
        val comments: List<Comment> = mapper.readValue(json)

        commentRepository.saveAll(comments)
    }

    fun loadAlbums() {

        val json = loadData("albums") ?: return
        val mapper = ObjectMapper()
        val albums: List<Album> = mapper.readValue(json)

        albumRepository.saveAll(albums)
    }

    fun loadPhotos() {

        val json = loadData("photos") ?: return
        val mapper = ObjectMapper()
        val photos: List<Photo> = mapper.readValue(json)

        photoRepository.saveAll(photos)
    }
}