package org.company.app.presentation.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import org.company.app.domain.model.Wallpaper
import org.company.app.presentation.ui.components.WallpaperList
import org.company.app.theme.LocalThemeIsDark

class HomeScreen(
    val wallpaper: Wallpaper,
) : Screen {

    @Composable
    override fun Content() {
        val state = rememberLazyGridState()
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .windowInsetsPadding(WindowInsets.safeDrawing)
        ) {

            Row(
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Wallpaper KMP",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(16.dp)
                )

                Spacer(modifier = Modifier.weight(1.0f))

                var isDark by LocalThemeIsDark.current
                IconButton(
                    onClick = { isDark = !isDark }
                ) {
                    Icon(
                        modifier = Modifier
                            .padding(8.dp)
                            .size(20.dp),
                        imageVector = if (isDark) Icons.Default.LightMode else Icons.Default.DarkMode,
                        contentDescription = null
                    )
                }
            }
            WallpaperList(wallpaper.photos, state)
        }

    }
}