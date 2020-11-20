package br.com.jabrahao.springcrudexample.repository

import br.com.jabrahao.springcrudexample.model.Post
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PostRepository: JpaRepository<Post, Int> {

}