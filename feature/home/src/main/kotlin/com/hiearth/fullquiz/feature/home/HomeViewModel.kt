package com.hiearth.fullquiz.feature.home

import androidx.lifecycle.ViewModel
import com.hiearth.fullquiz.core.data.UserRepository
import com.hiearth.fullquiz.feature.home.model.HomeUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {
    private val _uiState: MutableStateFlow<HomeUiState> = MutableStateFlow(HomeUiState.Init)
    val uiState: StateFlow<HomeUiState> = _uiState

    init {
        getNickname()
    }

    fun getNickname() {
        _uiState.update {
            HomeUiState.Success(
                nickname = userRepository.getNickname()
            )
        }

    }

}