package com.hiearth.fullquiz.feature.quiz

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hiearth.fullquiz.core.data.QuizRepository
import com.hiearth.fullquiz.core.data.UserRepository
import com.hiearth.fullquiz.core.model.Answer
import com.hiearth.fullquiz.core.model.Quiz
import com.hiearth.fullquiz.core.model.QuizType
import com.hiearth.fullquiz.feature.quiz.model.QuizUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuizViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val quizRepository: QuizRepository
) : ViewModel() {
    private val _uiState: MutableStateFlow<QuizUiState> = MutableStateFlow(QuizUiState.Loading)
    val uiState: StateFlow<QuizUiState> = _uiState

    init {
        getQuizList()
    }

    fun selectAnswer(quizId: Int, answer: Answer) {
        val quizList = (_uiState.value as QuizUiState.Success).quizList.map {
            if (it.quizId == quizId) {
                it.copy(userAnswer = answer)
            } else it
        }
        _uiState.update {
            QuizUiState.Success(
                quizList = quizList,
                interests = (_uiState.value as QuizUiState.Success).interests
            )
        }
    }

    private fun getQuizList() {
        viewModelScope.launch {
            quizRepository.getQuizList().onSuccess {
                _uiState.value = QuizUiState.Success(
                    quizList = it,
                    interests = userRepository.getInterest()
                )
            }.onFailure {
                _uiState.value = QuizUiState.Failure(it)
            }
        }
    }
}