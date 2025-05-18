package com.hiearth.fullquiz.core.network.datasource

import com.hiearth.fullquiz.core.network.model.ApiResponse
import com.hiearth.fullquiz.core.network.model.response.QuizProgressResponse
import com.hiearth.fullquiz.core.network.model.response.QuizResponse
import com.hiearth.fullquiz.core.network.model.response.UserResponse
import retrofit2.Response
import retrofit2.http.Query

interface QuizDataSource {
    suspend fun getQuizList(nickName: String, category: String): ApiResponse<QuizResponse>
    suspend fun postCurrentQuiz(nickName: String, quizId: String, isCorrect: Boolean, userAnswer: String): ApiResponse<Unit>
    suspend fun getProgressQuiz(
       quizProgressId: Long
    ): ApiResponse<QuizProgressResponse>
}