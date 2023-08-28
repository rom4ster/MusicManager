package com.rom4ster.musicmanager.util

import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import com.rom4ster.musicmanager.kmm.shared.entity.STATUS
import kotlin.reflect.KCallable
import kotlin.reflect.KFunction




object ViewUtils {

    @Composable
    fun SimpleCheckbox(runner: (Boolean)->Unit = {}) {
        val isChecked = remember { mutableStateOf(false) }

        Checkbox(checked = isChecked.value, onCheckedChange = {
            isChecked.value = it
            runner(it)
        }
        )
    }

    fun String.capitalize() = this.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }

    private val statusColors: Map<STATUS, Color> = mapOf(
        STATUS.DEFAULT to Color(0x00,0x6e,0xFF),
        STATUS.WHITELISTED to Color.Green,
        STATUS.DELETED to Color.Red
    )

    val STATUS.color
    get() = statusColors[this]



    data class DpDimensions(val width: Dp, val height: Dp)



}