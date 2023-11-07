package org.company.app

import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.Navigator
import io.github.aakira.napier.Napier
import io.ktor.util.logging.KtorSimpleLogger
import org.company.app.data.model.Wallpaper
import org.company.app.repository.Repository
import org.company.app.theme.AppTheme
import org.company.app.ui.screens.HomeScreen
import org.company.app.viewmodel.MainViewModel

@Composable
internal fun App() = AppTheme {

    val state = rememberLazyGridState()
    val isDesktop = LocalDensity.current.run { state.firstVisibleItemScrollOffset.toDp() } == 0.dp


    val repository = Repository()
    val viewModel: MainViewModel = MainViewModel(repository)

    var data by remember {
        mutableStateOf(Unit)
    }
    var wallpaper by remember {
        mutableStateOf<Wallpaper?>(null)
    }


    LaunchedEffect(true) {
        viewModel.getWallpaper(page = 1, per_pag = 80)
        viewModel.wallpaper.collect { wallpaperValue ->
            wallpaper = wallpaperValue
            Napier.d(message = "$wallpaper", throwable = null, tag = "MAIN")
            KtorSimpleLogger("MAIN")
        }

        // wallpaper = WallpaperClientApi.getWallpapers(80, 1)
        Napier.d(message = "$wallpaper", throwable = null, tag = "MAIN")
        KtorSimpleLogger("MAIN")


    }




    wallpaper?.let { wallpaper ->
        Navigator(HomeScreen(wallpaper))
    }

}


internal expect fun openUrl(url: String?)



