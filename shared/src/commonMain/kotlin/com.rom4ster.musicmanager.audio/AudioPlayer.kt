package com.rom4ster.musicmanager.audio

expect class AudioPlayer() {


    fun load(filePath: String)
    fun pause()
    fun play()
    fun stop()
}