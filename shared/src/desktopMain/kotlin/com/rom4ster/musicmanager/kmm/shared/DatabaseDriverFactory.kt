package com.rom4ster.musicmanager.kmm.shared

import com.rom4ster.musicmanager.kmm.database.MusicDb
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.sqlite.driver.JdbcSqliteDriver


actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver =
        JdbcSqliteDriver(JdbcSqliteDriver.IN_MEMORY).apply {
            MusicDb.Schema.create(this)
        }
}