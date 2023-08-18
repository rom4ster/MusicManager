package com.rom4ster.musicmanager.kmm.shared

import android.content.Context
import com.rom4ster.musicmanager.kmm.database.MusicDb
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual class DatabaseDriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver = AndroidSqliteDriver(MusicDb.Schema, context, "music.db")
}