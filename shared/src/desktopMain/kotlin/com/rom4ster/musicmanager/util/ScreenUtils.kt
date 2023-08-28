package com.rom4ster.musicmanager.util

import androidx.compose.ui.window.WindowState



actual object ScreenUtils {
    public val windowState: WindowState = WindowState()
    actual fun getScreenDim(): ViewUtils.DpDimensions = with(windowState.size) { ViewUtils.DpDimensions(this.width, this.height ) }

}