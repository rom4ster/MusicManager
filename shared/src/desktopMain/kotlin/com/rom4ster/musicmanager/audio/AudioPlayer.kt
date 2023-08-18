package com.rom4ster.musicmanager.audio

import korlibs.audio.sound.*
import korlibs.io.file.std.toVfs
import kotlinx.coroutines.runBlocking
import java.io.File

actual class AudioPlayer actual constructor() {
    var currentStream: SoundChannel? = null
    var currentSound: Sound? = null


    private suspend fun load_p(filePath: String)  = File(filePath).takeIf { it.exists() }?.toVfs()?.readSound()


    private fun isValidStream() = (currentStream != null)
    private fun isValidSound() = (currentSound != null)

    actual fun load(filePath: String) {
        runBlocking {
           currentSound =  load_p(filePath)
        }
    }

    actual fun pause() {
        if (!isValidStream()) return
        if (currentStream?.paused == true) return
        currentStream?.pause()

    }

    actual fun play() {
        if (!isValidSound()) return
        if ( currentStream?.playing == true) return
        currentStream = runBlocking { currentSound?.play() }
    }

    actual fun stop() {
        if (!isValidStream()) return
        currentStream?.stop()
    }

}