package com.hiearth.fullquiz.core.data

import com.hiearth.fullquiz.core.model.Category

interface QuizMyRepository {
    suspend fun getMyStatus(nickname: String): Result<List<Category>>
}