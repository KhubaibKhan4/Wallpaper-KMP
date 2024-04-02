package org.company.app.viewmodel

import com.rickclephas.kmm.viewmodel.KMMViewModel
import com.rickclephas.kmm.viewmodel.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.company.app.domain.model.WallpaperState
import org.company.app.repository.Repository

class MainViewModel(private val repository: Repository) : KMMViewModel() {

    private val _wallpaperState = MutableStateFlow<WallpaperState>(WallpaperState.Loading)
    val wallpapers: StateFlow<WallpaperState> = _wallpaperState

    fun getWallpapers(page: Int, per_pag: Int) {
        viewModelScope.coroutineScope.launch {
            _wallpaperState.value = WallpaperState.Loading
            try {
                val response = repository.getWallpaper(page, per_pag)
                _wallpaperState.value = WallpaperState.Success(response)
            } catch (e: Exception) {
                _wallpaperState.value = WallpaperState.Loading
            }
        }
    }


}