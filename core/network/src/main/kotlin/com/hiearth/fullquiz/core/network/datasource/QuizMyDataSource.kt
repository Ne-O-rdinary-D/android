package com.hiearth.fullquiz.core.network.datasource

import com.hiearth.fullquiz.core.network.model.ApiResponse
import com.hiearth.fullquiz.core.model.QuizMyResponse

interface QuizMyDataSource {
    suspend fun getMyStatus(nickname: String): ApiResponse<QuizMyResponse>
}