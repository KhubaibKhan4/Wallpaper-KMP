package org.company.app.domain.repository

import org.company.app.data.remote.WallpaperClientApi
import org.company.app.data.repository.WallpaperApi
import org.company.app.domain.model.Wallpaper

class Repository : WallpaperApi {
    override suspend fun getWallpapers(per_page: Int, page: Int): Wallpaper {
        return WallpaperClientApi.getWallpapers(per_page, page)
    }
}