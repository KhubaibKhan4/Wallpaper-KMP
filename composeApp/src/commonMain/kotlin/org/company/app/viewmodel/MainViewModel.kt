package org.company.app.viewmodel

import com.rickclephas.kmm.viewmodel.KMMViewModel
import com.rickclephas.kmm.viewmodel.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import org.company.app.data.model.Wallpaper
import org.company.app.repository.Repository

class MainViewModel(private val repository: Repository) : KMMViewModel() {

    private val _wallpapers = MutableStateFlow<Wallpaper?>(null)
    val wallpaper: Flow<Wallpaper?> = _wallpapers

    fun getWallpaper(page: Int, per_pag: Int): Wallpaper? {
        viewModelScope.coroutineScope.launch {
            val response = repository.getWallpaper(page, per_pag)
            _wallpapers.value = response
        }
        return _wallpapers.value
    }

}