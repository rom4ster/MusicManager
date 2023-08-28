package com.rom4ster.musicmanager.kmm.shared

import com.rom4ster.musicmanager.kmm.database.MusicDb
import com.rom4ster.musicmanager.util.FileUtils
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.sqlite.driver.JdbcSqliteDriver
import java.io.File
import java.sql.SQLException


actual class DatabaseDriverFactory {

    private val DB_FILE_PATH = "${FileUtils.getFileDirectory()}/musicDB"
    actual fun createDriver(): SqlDriver =
        JdbcSqliteDriver("jdbc:sqlite:$DB_FILE_PATH").apply {
            if (!File(DB_FILE_PATH).exists()) {
                MusicDb.Schema.create(this)
            }
        }



}