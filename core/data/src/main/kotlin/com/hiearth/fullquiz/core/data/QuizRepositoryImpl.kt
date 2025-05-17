package com.hiearth.fullquiz.core.data

import com.hiearth.fullquiz.core.data.mapper.toQuiz
import com.hiearth.fullquiz.core.data.mapper.toResult
import com.hiearth.fullquiz.core.model.Quiz
import com.hiearth.fullquiz.core.network.datasource.QuizDataSource
import com.hiearth.fullquiz.core.network.di.FakeQuiz
import javax.inject.Inject

class QuizRepositoryImpl @Inject constructor(
    @FakeQuiz private val quizDataSource: QuizDataSource
) : QuizRepository {
    override suspend fun getQuizList(): Result<List<Quiz>> {
        return quizDataSource.getQuizList().toResult(
            transform = { it.map { quiz -> quiz.toQuiz() } }
        )
    }
}