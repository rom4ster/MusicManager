package com.rom4ster.musicmanager.util

import androidx.compose.ui.unit.dp
import applicationContext

actual object ScreenUtils {
    actual fun getScreenDim(): ViewUtils.DpDimensions = applicationContext.resources.displayMetrics.let {
        ViewUtils.DpDimensions(
            (it.heightPixels / it.density).dp,
            (it.widthPixels / it.density).dp
        )
    }


}