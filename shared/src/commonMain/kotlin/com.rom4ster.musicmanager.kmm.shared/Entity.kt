package com.rom4ster.musicmanager.kmm.shared.entity

import kotlinx.serialization.Serializable

@Serializable
data class Song(
    val name: String,
    val path: String?,
    val uploader: String? = null,
    val ordinal: Int,
    val SongMetaData: SongMetaData? = null
) {
    constructor(name: String, ordinal: Int, ) : this(name, null, null, ordinal, null)
}

@Serializable
data class SongMetaData(
    val genres: Set<String>?,
    val albumInfo: AlbumInfo?
)

@Serializable
data class AlbumInfo (
    val artist: String?,
    val name: String?,
    val releaseDate: String?
) {
    constructor() : this(null,null,null)
}


