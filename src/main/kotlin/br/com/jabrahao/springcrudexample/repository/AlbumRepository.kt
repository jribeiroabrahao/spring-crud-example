package br.com.jabrahao.springcrudexample.repository

import br.com.jabrahao.springcrudexample.model.Album
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AlbumRepository: JpaRepository<Album, Int> {

}