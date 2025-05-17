package com.hiearth.fullquiz.feature.quiz.model

import com.hiearth.fullquiz.core.model.Quiz

sealed class QuizUiState() {

    data object Loading : QuizUiState()
    data class Success(val quizList: List<Quiz>) : QuizUiState()
    data class Failure(val throwable: Throwable) : QuizUiState()
}