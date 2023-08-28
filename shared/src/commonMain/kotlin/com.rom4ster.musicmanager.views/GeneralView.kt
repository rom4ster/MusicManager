package com.rom4ster.musicmanager.views

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.rom4ster.musicmanager.viewmodels.ViewModelBase

abstract class GeneralView<T>(private val initialState: T) {



    lateinit var state: MutableState<T>
    lateinit var viewModel: ViewModelBase<T>

    @Composable abstract fun render()
    @Composable fun createComponent() {
        state = remember { state }
        render()
    }

     fun bind(viewModel: ViewModelBase<T>) {
         this.viewModel = viewModel
     }


    fun update(state: T) {
        this.state = mutableStateOf(state)
    }


    //TODO See if u can set up an observer for "state" so that when state changes this func is called. 
    fun updateViewModel() = viewModel.update(state.value)

}