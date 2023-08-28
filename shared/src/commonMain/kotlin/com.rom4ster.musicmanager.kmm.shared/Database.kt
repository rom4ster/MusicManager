package com.rom4ster.musicmanager.kmm.shared

import com.rom4ster.musicmanager.kmm.database.MusicDb
import com.rom4ster.musicmanager.kmm.shared.entity.AlbumInfo
import com.rom4ster.musicmanager.kmm.shared.entity.STATUS
import com.rom4ster.musicmanager.kmm.shared.entity.Song
import com.rom4ster.musicmanager.kmm.shared.entity.SongMetaData
import com.squareup.sqldelight.db.Closeable
import com.squareup.sqldelight.db.SqlDriver
import comrom4stermusicmanagerkmmdatabase.MusicDbQueries

import kotlin.reflect.KProperty1

open class Database(databaseDriverFactory: DatabaseDriverFactory)  {
    private val database = MusicDb(databaseDriverFactory.createDriver())
    private val dbQueries = database.musicDbQueries

    fun insertSong(song: Song) = dbQueries.insertSong(
        song.name,
        song.path,
        song.uploader,
        song.ordinal,
        song.status.status
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

    fun selectAllSongs(): List<Song> = dbQueries.selectAllSongs().executeAsList().map { Song(it.name, it.path, it.uploader, it.ordinal ?: 0, STATUS.valueOf(it.status)) }

    fun selectSongs(vararg names: String) = dbQueries.selectSongs(names.toList()).executeAsList()

    fun clearSongs() = dbQueries.removeAllSongs()



}


