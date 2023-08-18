package com.rom4ster.musicmanager.util

import KContext
import android.Manifest
import android.content.Context
import androidx.core.app.ActivityCompat.requestPermissions
import androidx.startup.Initializer
import applicationContext

public class ContextInitializer : Initializer<KContext> {
    override fun create(context: Context): KContext {
        applicationContext = context.applicationContext


        return KContext
    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>>  = mutableListOf()

}