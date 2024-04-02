package org.company.app.data.repository

import org.company.app.domain.model.Wallpaper

interface WallpaperApi {
    suspend fun getWallpapers(per_page: Int, page: Int): Wallpaper
}