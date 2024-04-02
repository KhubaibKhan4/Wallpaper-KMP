package org.company.app

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.Navigator
import org.company.app.domain.usecase.ResultState
import org.company.app.presentation.ui.screens.HomeScreen
import org.company.app.presentation.viewmodel.MainViewModel
import org.company.app.theme.AppTheme
import org.koin.compose.koinInject

@Composable
internal fun App() = AppTheme {
    val viewModel = koinInject<MainViewModel>()
    LaunchedEffect(Unit) {
        viewModel.getWallpapers(1, 80)
    }
    val state by viewModel.wallpapers.collectAsState()

    when (state) {
        is ResultState.Loading -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }

        is ResultState.Success -> {
            val wallpaper = (state as ResultState.Success).response
            Navigator(HomeScreen(wallpaper))
        }

        is ResultState.Error -> {
            val error = (state as ResultState.Error).error
            Text(error.toString())
        }

    }
}


internal expect fun openUrl(url: String?)



