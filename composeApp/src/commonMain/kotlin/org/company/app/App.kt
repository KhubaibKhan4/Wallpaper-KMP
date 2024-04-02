package org.company.app

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.Navigator
import org.company.app.domain.model.WallpaperState
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


    var wallpaperState by remember { mutableStateOf<WallpaperState>(WallpaperState.Loading) }

    LaunchedEffect(Unit) {
        viewModel.getWallpapers(1, 80)
        viewModel.wallpapers.collect() {
            wallpaperState = it

        }
    }

    when (wallpaperState) {
        is WallpaperState.Loading -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }

        is WallpaperState.Success -> {
            val wallpaper = (wallpaperState as WallpaperState.Success).wallpaper
            Navigator(HomeScreen(wallpaper))
        }

        is WallpaperState.Error -> {
            Text("Error While Fetching Data.....")
        }

    }


}


internal expect fun openUrl(url: String?)



