package org.company.app

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import io.github.aakira.napier.Napier
import io.ktor.util.logging.KtorSimpleLogger
import org.company.app.data.model.Wallpaper
import org.company.app.repository.Repository
import org.company.app.theme.AppTheme
import org.company.app.theme.LocalThemeIsDark
import org.company.app.ui.components.WallpaperList
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



    Column(modifier = Modifier.fillMaxSize().windowInsetsPadding(WindowInsets.safeDrawing)) {

        Row(
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Wallpaper KMP ${wallpaper?.photos?.get(0)?.photographer}",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(16.dp)
            )

            Spacer(modifier = Modifier.weight(1.0f))

            var isDark by LocalThemeIsDark.current
            IconButton(
                onClick = { isDark = !isDark }
            ) {
                Icon(
                    modifier = Modifier.padding(8.dp).size(20.dp),
                    imageVector = if (isDark) Icons.Default.LightMode else Icons.Default.DarkMode,
                    contentDescription = null
                )
            }
        }

        wallpaper?.photos?.let { WallpaperList(it, state) }
    }
}


internal expect fun openUrl(url: String?)