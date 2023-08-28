import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import com.rom4ster.musicmanager.kmm.shared.Database
import com.rom4ster.musicmanager.kmm.shared.DatabaseDriverFactory

actual fun getPlatformName(): String = "Desktop"

@Composable fun MainView() = App()

@Preview
@Composable
fun AppPreview() {
    App()
}

actual val DATABASE: Database = Database(DatabaseDriverFactory())