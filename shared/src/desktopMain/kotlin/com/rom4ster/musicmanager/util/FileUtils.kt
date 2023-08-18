package com.rom4ster.musicmanager.util

actual object FileUtils {
    actual fun getFileDirectory(): String = System.getProperty("user.dir")
}