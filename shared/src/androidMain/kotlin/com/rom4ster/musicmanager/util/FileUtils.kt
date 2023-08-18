package com.rom4ster.musicmanager.util

import applicationContext
import java.io.File


actual object FileUtils {

    actual fun getFileDirectory(): String = applicationContext.filesDir.path

}