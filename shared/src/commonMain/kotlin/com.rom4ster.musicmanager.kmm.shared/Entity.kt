package com.rom4ster.musicmanager.kmm.shared.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Song(
    val name: String,
    val path: String?,
    val uploader: String? = null,
    val ordinal: Int,
) {
    constructor(name: String, ordinal: Int) : this(name, null, null, ordinal)
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


