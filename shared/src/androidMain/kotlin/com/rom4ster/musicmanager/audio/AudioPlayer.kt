package com.rom4ster.musicmanager.audio

import android.media.AudioAttributes
import android.media.MediaPlayer
import applicationContext
import java.io.File
import java.io.FileInputStream

actual class AudioPlayer actual constructor()  {

    private var _prepared = false

    private val mediaPlayer = MediaPlayer().apply {
        setAudioAttributes(
            AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .setUsage(AudioAttributes.USAGE_MEDIA)
                .build()
        )
    }

    private fun prepare()  {
        if (!_prepared) {
            _prepared = true
            mediaPlayer.prepare()
        }

    }

    val isPlaying get() =  mediaPlayer.isPlaying


    actual fun load(filePath: String) {
        //... stop current first
        if (isPlaying) {mediaPlayer.stop()}
        _prepared = false
        //close mediaStream ASAP
        mediaPlayer.setDataSource(filePath)

        prepare()
    }




    actual fun pause() {
        // if media player is not prepared or is not playing something, no need to pause
        if (!_prepared || !isPlaying) {
            return
        }
        mediaPlayer.pause()

    }

    actual fun play() {
        // if media player is not prepared or is playing something, no need to play
        if (!_prepared || isPlaying) {
            return
        }
        mediaPlayer.start()


    }

    actual fun stop() {
        if (!_prepared || isPlaying) {
            return
        }
        mediaPlayer.stop()
    }
}