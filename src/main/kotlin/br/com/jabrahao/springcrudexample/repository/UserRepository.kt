package br.com.jabrahao.springcrudexample.repository

import br.com.jabrahao.springcrudexample.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<User, Int> {

}