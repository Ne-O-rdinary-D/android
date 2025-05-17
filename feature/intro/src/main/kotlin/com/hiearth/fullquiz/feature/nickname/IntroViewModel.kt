package com.hiearth.fullquiz.feature.nickname

import android.preference.PreferenceManager
import androidx.lifecycle.ViewModel
import com.hiearth.fullquiz.core.local.SharedPreferenceManager
import com.hiearth.fullquiz.feature.nickname.model.IntroUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


class IntroViewModel : ViewModel() {
    private val _uiState: MutableStateFlow<IntroUiState> = MutableStateFlow(IntroUiState.Init)
    val uiState: StateFlow<IntroUiState> = _uiState

    fun getLoginState() {
        SharedPreferenceManager.isLoggedIn()
    }
}