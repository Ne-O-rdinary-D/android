package com.hiearth.fullquiz.core.data

import com.hiearth.fullquiz.core.model.Quiz

interface QuizRepository {
    suspend fun getQuizList(): Result<List<Quiz>>
}