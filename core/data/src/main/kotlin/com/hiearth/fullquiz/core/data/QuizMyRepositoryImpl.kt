package com.hiearth.fullquiz.core.data

import com.hiearth.fullquiz.core.data.mapper.toCategory
import com.hiearth.fullquiz.core.data.mapper.toResult
import com.hiearth.fullquiz.core.model.Category
import com.hiearth.fullquiz.core.network.datasource.QuizMyDataSource
import javax.inject.Inject

class QuizMyRepositoryImpl @Inject constructor(
    private val quizMyDataSource: QuizMyDataSource
):QuizMyRepository {
    override suspend fun getMyStatus(nickname: String): Result<List<Category>> {
        return quizMyDataSource.getMyStatus(nickname).toResult(transform = {it.toCategory()})
    }
}