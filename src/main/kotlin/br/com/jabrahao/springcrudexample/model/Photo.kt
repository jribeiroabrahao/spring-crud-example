package br.com.jabrahao.springcrudexample.model

import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.*

@Entity
@Table(name = "photos")
class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null

    @ManyToOne
    @JoinColumn(name = "album_id")
    var album: Album? = null

    @Column(name = "title")
    var title: String? = null

    @Column(name = "url")
    var url: String? = null

    @Column(name = "thumbnail_url")
    var thumbnailUrl: String? = null

    @JsonProperty("albumId")
    fun setAlbumId(albumId: Int) {
        album = Album()
        album!!.id = albumId
    }
}