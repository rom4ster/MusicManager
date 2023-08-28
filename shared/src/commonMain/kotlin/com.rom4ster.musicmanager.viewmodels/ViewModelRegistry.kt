package com.rom4ster.musicmanager.viewmodels

import com.rom4ster.musicmanager.views.DBTableView
import com.squareup.sqldelight.db.Closeable

@OptIn(ExperimentalStdlibApi::class)
object ViewModelRegistry : AutoCloseable{
    val dbTableViewModel = DBTableViewModel()







    init {
        dbTableViewModel.view.bind(dbTableViewModel)
    }
    //Ghetto way of supporting use lol
    override fun close() {}
}