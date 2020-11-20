package br.com.jabrahao.springcrudexample.repository

import br.com.jabrahao.springcrudexample.model.Comment
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CommentRepository: JpaRepository<Comment, Int> {

}