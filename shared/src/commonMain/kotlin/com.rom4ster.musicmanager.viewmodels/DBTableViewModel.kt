package com.rom4ster.musicmanager.viewmodels

import DATABASE
import com.rom4ster.musicmanager.kmm.shared.Database
import com.rom4ster.musicmanager.kmm.shared.entity.Song
import com.rom4ster.musicmanager.views.DBTableView
import com.rom4ster.musicmanager.views.GeneralView

data class TableRow(
    val song: Song,
    val selected: Boolean
)

class DBTableViewModel : ViewModelBase<MutableList<TableRow>>(view = DBTableView(mutableListOf())){
    private var table: MutableList<TableRow>


    init {
        table = getTableFromDB().toMutableList()
        view.update(table)
    }
     fun getTable() = table

     private fun deleteRow(tableRow: TableRow) : Boolean = tableRow
         .takeIf { it.selected }
         ?.let {
             //REMOVE FROM DB
             val ret = table.remove(it)
             ret
         }
         ?: false
    private fun getTableFromDB() = DATABASE.selectAllSongs().map { TableRow(it, false)}

    override fun update(state: MutableList<TableRow>) {



        val deletions = table.filter { it !in state }
        // TODO MAKE ADDITION
        val additions = state.filter { it !in table }
        deletions.forEach { deleteRow(it) }
        table = state

        updateView(table)

    }

}