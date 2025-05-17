package com.hiearth.fullquiz.feature.rank

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hiearth.fullquiz.feature.rank.model.RankUiState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class RankViewModel : ViewModel() {
    private val _uiState: MutableStateFlow<RankUiState> = MutableStateFlow(RankUiState.test())
    val uiState: StateFlow<RankUiState> = _uiState

    fun reLoad() = viewModelScope.launch{
        _uiState.update{
            RankUiState.Loading
        }
        delay(500)
        _uiState.update{
            RankUiState.test()
        }
    }
}