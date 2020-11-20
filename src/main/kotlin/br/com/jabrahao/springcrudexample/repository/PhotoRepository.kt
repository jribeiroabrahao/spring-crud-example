package br.com.jabrahao.springcrudexample.repository

import br.com.jabrahao.springcrudexample.model.Photo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PhotoRepository: JpaRepository<Photo, Int> {

}