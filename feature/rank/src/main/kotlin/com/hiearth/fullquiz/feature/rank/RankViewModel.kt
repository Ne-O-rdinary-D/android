package com.hiearth.fullquiz.feature.rank

import androidx.lifecycle.ViewModel
import com.hiearth.fullquiz.feature.rank.model.RankUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class RankViewModel : ViewModel() {
    private val _uiState: MutableStateFlow<RankUiState> = MutableStateFlow(RankUiState.test())
    val uiState: StateFlow<RankUiState> = _uiState


}