package com.hiearth.fullquiz.core.data

import com.hiearth.fullquiz.core.model.QuizListDataSet

interface QuizRepository {
    suspend fun getQuizList(): Result<QuizListDataSet>

    suspend fun getQuizList(category:String): Result<QuizListDataSet>
    suspend fun postCurrentQuiz(quizId: String, isCorrect: Boolean, userAnswer: String): Result<Unit>
    suspend fun getProgressQuiz(
        quizProgressId: Long
    ): Result<QuizListDataSet>
}