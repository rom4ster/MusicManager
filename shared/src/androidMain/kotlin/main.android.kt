import android.content.Context
import androidx.compose.runtime.Composable

actual fun getPlatformName(): String = "Android"

@Composable fun MainView() = App()

internal lateinit var applicationContext: Context

public object KContext
