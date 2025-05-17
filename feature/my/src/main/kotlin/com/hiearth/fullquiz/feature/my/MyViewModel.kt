package com.hiearth.fullquiz.feature.my

import androidx.lifecycle.ViewModel
import com.hiearth.fullquiz.feature.my.model.MyUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MyViewModel : ViewModel() {
    private val _uiState: MutableStateFlow<MyUiState> = MutableStateFlow(MyUiState.test())
    val uiState: StateFlow<MyUiState> = _uiState

}