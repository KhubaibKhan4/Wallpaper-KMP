package org.company.app.data.model

sealed class WallpaperState {
    object Loading : WallpaperState()
    data class Success(val wallpaper: Wallpaper) : WallpaperState()
    object Error : WallpaperState()
}
