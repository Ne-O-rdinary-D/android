package com.hiearth.fullquiz.feature.quiz

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hiearth.fullquiz.core.data.QuizRepository
import com.hiearth.fullquiz.core.data.UserRepository
import com.hiearth.fullquiz.core.model.Answer
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

    private val _currentStep: MutableStateFlow<Int> = MutableStateFlow(0)
    val currentStep: StateFlow<Int> = _currentStep

    private var _initialized = false

    fun getQuizListOnce(category: String?) {
        if (_initialized) return
        _initialized = true

        if (category.isNullOrEmpty()) getQuizList()
        else getQuizList(category)
    }

    fun setCurrentStep(step: Int) {
        _currentStep.value = step
    }

    fun selectAnswer(quizId: Int, answer: Answer) {
        var isCorrect = false
        var userAnswer = ""
        val quizList = (_uiState.value as QuizUiState.Success).quizList.map {
            if (it.quizId == quizId) {
                isCorrect = it.answer == answer
                userAnswer = answer.toString()
                it.copy(userAnswer = answer)
            } else it
        }
        _uiState.update {
            QuizUiState.Success(
                quizList = quizList,
                interests = (_uiState.value as QuizUiState.Success).interests
            )
        }
        viewModelScope.launch {
            quizRepository.postCurrentQuiz(
                quizId = quizId.toString(),
                isCorrect = isCorrect,
                userAnswer = userAnswer
            )
        }
    }

    fun getQuizState(): Boolean {
        return (_uiState.value as QuizUiState.Success).quizList.all { it.userAnswer != null }
    }

    fun getCorrectQuizNum(): Int {
        return (_uiState.value as QuizUiState.Success).quizList.count { it.userAnswer == it.answer }
    }

    fun getQuizList() {
        viewModelScope.launch {
            quizRepository.getQuizList().onSuccess {
                var step = 0

                _uiState.value = QuizUiState.Success(
                    quizList = it.quizList,
                    interests = userRepository.getInterest()
                )

                it.quizList.forEach {
                    if (it.userAnswer != null) step++
                }

                _currentStep.value = step
            }.onFailure {
                _uiState.value = QuizUiState.Failure(it)
            }
        }
    }


    fun getQuizList(quizCategory: String) = viewModelScope.launch {
        val progressList = userRepository.getProgressIdList()
        if (progressList.map { it.first }.contains(quizCategory)) {
            quizRepository.getProgressQuiz(progressList.find { it.first == quizCategory }!!.second.toLong())
                .onSuccess {
                    _uiState.value = QuizUiState.Success(
                        quizList = it.quizList,
                        interests = userRepository.getInterest()
                    )
                }
        } else {
            quizRepository.getQuizList(quizCategory).onSuccess {
                _uiState.value = QuizUiState.Success(
                    quizList = it.quizList,
                    interests = userRepository.getInterest()
                )
            }.onFailure {
                _uiState.value = QuizUiState.Failure(it)
            }
        }
    }
}