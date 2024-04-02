package org.company.app.data.repository

import org.company.app.domain.model.Wallpaper

interface Repository {
    suspend fun getWallpapers(per_page: Int, page: Int): Wallpaper
}