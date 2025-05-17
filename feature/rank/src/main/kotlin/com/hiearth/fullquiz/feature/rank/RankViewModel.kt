package com.hiearth.fullquiz.feature.rank

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hiearth.fullquiz.core.data.RankRepository
import com.hiearth.fullquiz.core.data.UserRepository
import com.hiearth.fullquiz.feature.rank.model.RankUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RankViewModel @Inject constructor(
    private val rankRepository: RankRepository,
    private val userRepository: UserRepository
) : ViewModel() {
    private val _uiState: MutableStateFlow<RankUiState> = MutableStateFlow(RankUiState.Init)
    val uiState: StateFlow<RankUiState> = _uiState

    fun load() = viewModelScope.launch {
        _uiState.update {
            RankUiState.Loading
        }

        rankRepository.getLoadPage().onSuccess {
            val myRankData = it.first
            val rankList = it.second
            _uiState.update {
                RankUiState.Success(
                    nickname = userRepository.getNickname(),
                    myRankData = myRankData,
                    rankList = rankList
                )
            }
        }
    }

    fun reLoad() = viewModelScope.launch {
        val prev = uiState.value
        _uiState.update {
            RankUiState.Loading
        }
        if (prev is RankUiState.Success)
            rankRepository.getRankList().onSuccess { list ->
                _uiState.update {
                    prev.copy(
                        rankList = list
                    )
                }
            }
    }
}