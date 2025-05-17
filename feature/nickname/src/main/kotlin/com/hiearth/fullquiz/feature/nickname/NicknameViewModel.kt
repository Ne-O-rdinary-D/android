package com.hiearth.fullquiz.feature.nickname

import androidx.lifecycle.ViewModel
import com.hiearth.fullquiz.feature.nickname.model.NicknameUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


class NicknameViewModel : ViewModel() {
    private val _uiState: MutableStateFlow<NicknameUiState> = MutableStateFlow(NicknameUiState.Init)
    val uiState: StateFlow<NicknameUiState> = _uiState
}