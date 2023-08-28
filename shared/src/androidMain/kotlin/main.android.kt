import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import com.rom4ster.musicmanager.kmm.shared.Database
import com.rom4ster.musicmanager.kmm.shared.DatabaseDriverFactory

actual fun getPlatformName(): String = "Android"

internal lateinit var applicationContext: Context
internal lateinit var APPLICATION_DATASTORE: Database

@Composable fun MainView() = App()


public object KContext

@Synchronized
private fun databaseHelper() : Database {
    APPLICATION_DATASTORE = Database(DatabaseDriverFactory(applicationContext))
    return APPLICATION_DATASTORE
}

actual val DATABASE: Database
    get()  = if (::APPLICATION_DATASTORE.isInitialized) {APPLICATION_DATASTORE} else{  databaseHelper()}