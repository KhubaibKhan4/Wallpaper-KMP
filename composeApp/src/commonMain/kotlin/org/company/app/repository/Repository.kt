package org.company.app.repository

import org.company.app.domain.model.Wallpaper
import org.company.app.data.remote.WallpaperClientApi

class Repository {

    suspend fun getWallpaper(page: Int, per_page: Int): Wallpaper {
        return WallpaperClientApi.getWallpapers(per_page, page)
    }

}