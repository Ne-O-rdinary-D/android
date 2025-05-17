package com.hiearth.fullquiz.feature.my

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hiearth.fullquiz.core.data.QuizMyRepository
import com.hiearth.fullquiz.core.data.UserRepository
import com.hiearth.fullquiz.feature.my.model.MyUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    private val quizMyRepository: QuizMyRepository,
    private val userRepository: UserRepository
) : ViewModel() {
    private val _uiState: MutableStateFlow<MyUiState> = MutableStateFlow(MyUiState.Init)
    val uiState: StateFlow<MyUiState> = _uiState

    fun getMyStatus() = viewModelScope.launch {
        _uiState.update {
            MyUiState.Loading
        }

        val nickname = userRepository.getNickname()
        val interset = userRepository.getInterest()
        quizMyRepository.getMyStatus(nickname.ifEmpty { "test" }
        ).onSuccess { chapterStatusList ->
            _uiState.update {
                MyUiState.Success(
                    nickname = nickname,
                    chapterStatusList = chapterStatusList.sortedByDescending { it.bigCategory == interset }
                )
            }
        }.onFailure { throwable ->
            _uiState.update {
                MyUiState.Failure(throwable)
            }
        }
    }
}