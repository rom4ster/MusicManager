package com.rom4ster.musicmanager.kmm.shared

import com.squareup.sqldelight.db.SqlDriver

actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        throw NotImplementedError("NO CRAPPLE")
    }
}