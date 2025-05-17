package com.hiearth.fullquiz.core.data

import com.hiearth.fullquiz.core.model.Quiz

interface QuizRepository {
    suspend fun getQuizList(): Result<List<Quiz>>

    suspend fun getQuizList(category:String): Result<List<Quiz>>
    suspend fun postCurrentQuiz(quizId: String, isCorrect: Boolean, userAnswer: String): Result<Unit>
}