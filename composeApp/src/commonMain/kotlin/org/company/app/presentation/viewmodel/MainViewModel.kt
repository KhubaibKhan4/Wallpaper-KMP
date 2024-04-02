package org.company.app.presentation.viewmodel

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.company.app.domain.model.Wallpaper
import org.company.app.domain.repository.Repository
import org.company.app.domain.usecase.ResultState

class MainViewModel(private val repository: Repository) : ViewModel() {

    private val _wallpaperState = MutableStateFlow<ResultState<Wallpaper>>(ResultState.Loading)
    val wallpapers: StateFlow<ResultState<Wallpaper>> = _wallpaperState

    fun getWallpapers(page: Int, per_pag: Int) {
        viewModelScope.launch {
            _wallpaperState.value = ResultState.Loading
            try {
                val response = repository.getWallpapers(page, per_pag)
                _wallpaperState.value = ResultState.Success(response)
            } catch (e: Exception) {
                _wallpaperState.value = ResultState.Loading
            }
        }
    }


}