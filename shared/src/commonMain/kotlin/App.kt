import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.rom4ster.musicmanager.audio.AudioPlayer
import com.rom4ster.musicmanager.kmm.shared.Database
import com.rom4ster.musicmanager.kmm.shared.DatabaseDriverFactory
import com.rom4ster.musicmanager.kmm.shared.entity.Song
import com.rom4ster.musicmanager.util.FileUtils
import com.rom4ster.musicmanager.viewmodels.ViewModelRegistry
import com.squareup.sqldelight.db.Closeable
import kotlinx.coroutines.runBlocking
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class, ExperimentalStdlibApi::class)
@Composable
fun App() {
    MaterialTheme {
//        var greetingText by remember { mutableStateOf("Hello, World!") }
//        var dbBox by remember { mutableStateOf("THING") }
//        var showImage by remember { mutableStateOf(false) }
//        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
//            Button(onClick = {
//                greetingText = "Hello, ${getPlatformName()}"
//                showImage = !showImage
//            }) {
//                Text(greetingText)
//            }
//            Button(
//                onClick = {
//                    runBlocking {
//                        AudioPlayer().apply {
//                            load("${FileUtils.getFileDirectory()}/test.mp3")
//                            play()
//                        }
//                    }
//
//                }
//            ) {
//                Text(FileUtils.getFileDirectory())
//            }
//            Button(
//                onClick = {
//                    runBlocking {
//
//                        DATABASE.clearSongs()
//                        DATABASE.insertSong(Song("MYSONG", null, null, 0))
//                        dbBox = DATABASE.selectAllSongs().map { it.toString() }.joinToString(separator = ","){ it }
//                    }
//                }
//            ) {
//                Text(dbBox)
//            }
//            AnimatedVisibility(showImage) {
//                Image(
//                    painterResource("compose-multiplatform.xml"),
//                    null
//                )
//            }
//        }

        ViewModelRegistry.dbTableViewModel.view.createComponent()


    }
}




expect fun getPlatformName(): String

expect val DATABASE : Database

