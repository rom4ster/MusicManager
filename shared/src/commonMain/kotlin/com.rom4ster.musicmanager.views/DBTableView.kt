package com.rom4ster.musicmanager.views

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.rom4ster.musicmanager.viewmodels.TableRow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalViewConfiguration
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rom4ster.musicmanager.util.FileUtils
import com.rom4ster.musicmanager.util.ScreenUtils
import com.rom4ster.musicmanager.util.ViewUtils
import com.rom4ster.musicmanager.util.ViewUtils.capitalize
import com.rom4ster.musicmanager.util.ViewUtils.color

@Suppress("UNCHECKED_CAST")
class DBTableView(private val initialState: List<TableRow>) :
    GeneralView<MutableList<TableRow>>(initialState = initialState.toMutableList()) {


    @Composable
    override fun render() {
        val greetingText by remember { mutableStateOf("DELETE") }
        var rowHolder by remember { mutableStateOf(state.value) }

        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = {
                //state.value.add(TableRow(Song("sup", 0),false))
                state.value.removeAll { it.selected }
                updateViewModel()
                rowHolder = state.value

            }) {
                Text(greetingText)

            }

            renderTable(rowHolder)
        }


    }


    @OptIn(ExperimentalLayoutApi::class)
    @Composable
    private fun renderTable(rowHolder: MutableList<TableRow>) {
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(ScreenUtils.getScreenDim().width.toString())


//            FlowRow(modifier = Modifier.fillMaxWidth().padding(bottom = HEADER_DIVIDER_TOP_OFFSET.dp), horizontalArrangement = Arrangement.SpaceEvenly) {
//                Box(modifier = Modifier.fillMaxWidth(TABLE_BOX_SIZE), contentAlignment = Alignment.Center) {Text("Name")}
//                Box(modifier = Modifier.fillMaxWidth(TABLE_BOX_SIZE),contentAlignment = Alignment.Center) {Text("Path")}
//                Box(modifier = Modifier.fillMaxWidth(TABLE_BOX_SIZE),contentAlignment = Alignment.Center) {Text("Uploader")}
//                Box(modifier = Modifier.fillMaxWidth(TABLE_BOX_SIZE),contentAlignment = Alignment.Center) {Text("Status")}
//                Box(modifier = Modifier.fillMaxWidth(TABLE_BOX_SIZE),contentAlignment = Alignment.Center) {Text("Selected")}
//            }
//            Divider(color= HEADER_DIVIDER_COLOR, thickness = HEADER_DIVIDER_THICKNESS.dp, modifier = Modifier.padding(bottom = SPACE_AFTER_HEADER_ROW.dp))


            LazyVerticalGrid(
                columns = GridCells.Adaptive(ScreenUtils.getScreenDim().width.takeIf { it < GRID_MIN_CELL_WIDTH.dp }
                    ?: GRID_MIN_CELL_WIDTH.dp)
            ) {

                items(state.value.size) { index ->
                    Card(
                        modifier = Modifier.fillMaxWidth()
                            .padding(horizontal = CARD_HORIZ_PADDING.dp)
                            .padding(bottom = CARD_VERT_PADDING.dp),
                        elevation = CARD_ELEVATION.dp,
                        shape = RoundedCornerShape(CARD_CORNERS.dp),
                    ) {


                        Box(Modifier.fillMaxWidth()) {
                            val status = state.value[index].song.status
                            Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.TopEnd) {
                                Card(
                                    modifier = Modifier.fillMaxWidth(STATUS_CARD_SIZE)
                                        .padding(horizontal = STATUS_CARD_HORIZ_PADDING.dp)
                                        .padding(vertical = STATUS_CARD_VERT_PADDING.dp),
                                    elevation = 0.dp,
                                    shape = RoundedCornerShape(CARD_CORNERS.dp),
                                    backgroundColor = status.color ?: Color.Transparent
                                ) {
                                    Text(
                                        status.status.capitalize(),
                                        textAlign = TextAlign.Center,
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = STATUS_CARD_COLOR
                                    )
                                }
                            }

                            Box() {
                                ViewUtils.SimpleCheckbox(runner = {
                                    state.value[index] = TableRow(state.value[index].song, it)

                                    updateViewModel()
                                })
                            }







                            Column(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {

                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center,
                                ) {
                                    Text(state.value[index].song.name, textAlign = TextAlign.Center)

                                }
                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        state.value[index].song.uploader ?: "",
                                        textAlign = TextAlign.Center
                                    )
                                }
                                OutlinedButton(
                                    modifier = Modifier.fillMaxWidth(FILE_BUTTON_SIZE)
                                        .align(Alignment.CenterHorizontally),
                                    shape = RoundedCornerShape(FILE_BUTTON_CORNERS.dp),
                                    colors = ButtonDefaults.buttonColors(backgroundColor = FILE_BUTTON_BACKGORUND),
                                    border = BorderStroke(
                                        FILE_BUTTON_BORDER.dp,
                                        FILE_BUTTON_BORDER_COLOR
                                    ),
                                    onClick = {

                                    }
                                ) {
                                    Text(text = "View In Folder", textAlign = TextAlign.Center)
                                }

                            }
                        }

                    }
                }
            }
//            for (i in 0 until state.value.size) {
//
//                Card(
//                    modifier = Modifier.fillMaxWidth().padding(horizontal = CARD_HORIZ_PADDING.dp)
//                        .padding(bottom = CARD_VERT_PADDING.dp),
//                    elevation = CARD_ELEVATION.dp,
//                    shape = RoundedCornerShape(CARD_CORNERS.dp),
//                ) {
//
//
//                    Column(
//                        modifier = Modifier.fillMaxWidth(),
//                        horizontalAlignment = Alignment.CenterHorizontally
//                    ) {
//
//                        Box(
//                            modifier = Modifier.fillMaxWidth(),
//                            contentAlignment = Alignment.Center,
//                        ) {
//                            Text(state.value[i].song.name)
//
//                        }
//                        Box(
//                            modifier = Modifier.fillMaxWidth(),
//                            contentAlignment = Alignment.Center
//                        ) {
//                            Text(state.value[i].song.uploader ?: "")
//                        }
//                        OutlinedButton(
//                            modifier = Modifier.fillMaxWidth(FILE_BUTTON_SIZE)
//                                .align(Alignment.CenterHorizontally),
//                            shape = RoundedCornerShape(FILE_BUTTON_CORNERS.dp),
//                            colors = ButtonDefaults.buttonColors(backgroundColor = FILE_BUTTON_BACKGORUND),
//                            border = BorderStroke(FILE_BUTTON_BORDER.dp, FILE_BUTTON_BORDER_COLOR),
//                            onClick = {
//
//                            }
//                        ) {
//                            Text("View In Folder")
//                        }
//
//                    }
//
//
//                }
//
//            }
//                FlowRow(modifier = Modifier.fillMaxWidth().padding(bottom = ROW_DIVIDER_TOP_OFFSET.dp), horizontalArrangement = Arrangement.SpaceEvenly) {
//
//
//                    Box(modifier = Modifier.fillMaxWidth(TABLE_BOX_SIZE),contentAlignment = Alignment.Center) {Text(state.value[i].song.name) }
//                    Box(modifier = Modifier.fillMaxWidth(TABLE_BOX_SIZE),contentAlignment = Alignment.Center) {Text(state.value[i].song.path ?: " ")}
//                    Box(modifier = Modifier.fillMaxWidth(TABLE_BOX_SIZE),contentAlignment = Alignment.Center) {Text(state.value[i].song.uploader ?: " ")}
//                    Box(modifier = Modifier.fillMaxWidth(TABLE_BOX_SIZE),contentAlignment = Alignment.Center) {Text(state.value[i].song.status.status)}
//                    Box(modifier = Modifier.fillMaxWidth(TABLE_BOX_SIZE).padding( top = CHECKBOX_PADDING_TOP.dp).size(CHECKBOX_SIZE.dp) ,contentAlignment = Alignment.Center) {
////                        Checkbox(checked = remember { mutableStateOf(state.value[i].selected) }.value, onCheckedChange =  {
////                        state.value[i] = TableRow(state.value[i].song, it)
////                        rowHolder[i] = TableRow(state.value[i].song, it)
////                        updateViewModel()
////                    }
////                        )
//                        ViewUtils.SimpleCheckbox( runner =  {
//                            state.value[i] = TableRow(state.value[i].song, it)
//
//                            updateViewModel()
//                        }
//
//                        )
//                    }
//
//                }
//                Divider(color= ROW_DIVIDER_COLOR, thickness = ROW_DIVIDER_THICKNESS.dp, modifier = Modifier.padding(bottom = SPACE_AFTER_NORMAL_ROW.dp))


        }
    }

    companion object {
        private const val GRID_MIN_CELL_WIDTH = 384
        private const val CARD_HORIZ_PADDING = 10
        private const val CARD_ELEVATION = 10
        private const val CARD_CORNERS = 10
        private const val CARD_VERT_PADDING = 20
        private const val FILE_BUTTON_CORNERS = 10
        private const val FILE_BUTTON_SIZE = .5f
        private const val STATUS_CARD_SIZE = .25f
        private const val STATUS_CARD_HORIZ_PADDING = 10
        private const val STATUS_CARD_VERT_PADDING = 10

        private const val TABLE_BOX_SIZE = 0.15f
        private const val SPACE_AFTER_HEADER_ROW = 20
        private const val SPACE_AFTER_NORMAL_ROW = 15
        private const val HEADER_DIVIDER_THICKNESS = 5
        private const val ROW_DIVIDER_THICKNESS = 3
        private const val HEADER_DIVIDER_TOP_OFFSET = 20
        private const val ROW_DIVIDER_TOP_OFFSET = 10
        private const val CHECKBOX_SIZE = 8
        private const val CHECKBOX_PADDING_TOP = 4
        private val HEADER_DIVIDER_COLOR = Color.Red
        private val ROW_DIVIDER_COLOR = Color.Black
        private val FILE_BUTTON_BACKGORUND = Color.Transparent
        private val FILE_BUTTON_BORDER = Dp.Hairline.value
        private val STATUS_CARD_COLOR = Color.White
        private val FILE_BUTTON_BORDER_COLOR: Color
            @Composable get() = MaterialTheme.colors.primary
    }
}