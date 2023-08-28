import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import com.rom4ster.musicmanager.util.ScreenUtils


fun main() = application {
    Window(onCloseRequest = ::exitApplication, state = ScreenUtils.windowState) {
        MainView()
    }
}