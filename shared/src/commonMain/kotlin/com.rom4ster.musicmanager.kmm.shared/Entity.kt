package com.rom4ster.musicmanager.kmm.shared.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


enum class STATUS(val status: String){
    DELETED("deleted"),
    WHITELISTED("whitelisted"),
    DEFAULT("default"),
}
@Serializable
data class Song(
    val name: String,
    val path: String?,
    val uploader: String? = null,
    val ordinal: Long,
    val status: STATUS
) {
    constructor(name: String, ordinal: Long, status: STATUS) : this(name, null, null, ordinal, status)
}

@Serializable
data class SongMetaData(
    val name: String,
    val genres: Set<String>?,
)

@Serializable
data class AlbumInfo(
    val name: String,
    val artist: String?,
    @SerialName("album_name")
    val albumName: String?,
    @SerialName("release_date")
    val releaseDate: String?
) {
    constructor(name: String) : this(name, null,null,null)
    constructor(song: Song) : this(song.name)
}


