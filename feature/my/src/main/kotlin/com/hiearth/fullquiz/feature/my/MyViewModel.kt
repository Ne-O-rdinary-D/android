package com.hiearth.fullquiz.feature.my

import androidx.lifecycle.ViewModel
import com.hiearth.fullquiz.core.data.MyRepository
import com.hiearth.fullquiz.feature.my.model.MyUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    private val myRepository: MyRepository
) : ViewModel() {
    private val _uiState: MutableStateFlow<MyUiState> = MutableStateFlow(MyUiState.test())
    val uiState: StateFlow<MyUiState> = _uiState

}