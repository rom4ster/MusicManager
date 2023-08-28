package com.rom4ster.musicmanager.viewmodels

import androidx.compose.runtime.MutableState
import com.rom4ster.musicmanager.views.GeneralView

abstract class ViewModelBase<T>(val view: GeneralView<T>) : BindableViewModel {
     abstract fun update(state: T)
     fun updateView(state: T) = view.update(state)
}