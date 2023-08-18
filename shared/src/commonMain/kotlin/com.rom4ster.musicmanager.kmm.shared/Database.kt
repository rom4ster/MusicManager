package com.rom4ster.musicmanager.kmm.shared

import com.rom4ster.musicmanager.kmm.database.MusicDb
import com.rom4ster.musicmanager.kmm.shared.entity.AlbumInfo
import com.rom4ster.musicmanager.kmm.shared.entity.SongMetaData
import comrom4stermusicmanagerkmmdatabase.MusicDbQueries
import comrom4stermusicmanagerkmmdatabase.Song
import kotlin.reflect.KProperty1

internal class Database(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = MusicDb(databaseDriverFactory.createDriver())
    private val dbQueries = database.musicDbQueries


    fun insertSong(song: Song) = dbQueries.insertSong(
        song.name,
        song.path,
        song.uploader,
        song.ordinal
    )

    fun insertSongMetaData(metaData: SongMetaData) = dbQueries.insertSongMetaData(
        metaData.name,
        metaData.genres
            ?.map { it.encodeToByteArray()}
            ?.fold(byteArrayOf()) { acc, bytes ->
                acc+bytes
            }
    )

    fun insertAlbumInfo(albumInfo: AlbumInfo) = dbQueries.insertAlbumInfo(
        albumInfo.name,
        albumInfo.artist,
        albumInfo.albumName,
        albumInfo.releaseDate
    )

    fun selectAllSongs() = dbQueries.selectAllSongs().executeAsList()

    fun selectSongs(vararg names: String) = dbQueries.selectSongs(names.toList()).executeAsList()



}


