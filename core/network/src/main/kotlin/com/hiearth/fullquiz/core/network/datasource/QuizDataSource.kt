package com.hiearth.fullquiz.core.network.datasource

import com.hiearth.fullquiz.core.network.model.ApiResponse
import com.hiearth.fullquiz.core.network.model.response.QuizResponse
import com.hiearth.fullquiz.core.network.model.response.UserResponse

interface QuizDataSource {
    suspend fun getQuizList(): ApiResponse<List<QuizResponse>>
}