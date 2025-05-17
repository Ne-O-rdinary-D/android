package com.hiearth.fullquiz.core.data

import com.hiearth.fullquiz.core.data.mapper.toQuiz
import com.hiearth.fullquiz.core.data.mapper.toResult
import com.hiearth.fullquiz.core.model.Interests
import com.hiearth.fullquiz.core.model.Quiz
import com.hiearth.fullquiz.core.network.datasource.QuizDataSource
import com.hiearth.fullquiz.core.network.datasource.UserDataSource
import com.hiearth.fullquiz.core.network.di.FakeQuiz
import javax.inject.Inject

class QuizRepositoryImpl @Inject constructor(
    private val userRepository: UserRepository,
    private val quizDataSource: QuizDataSource
) : QuizRepository {
    override suspend fun getQuizList(): Result<List<Quiz>> {
        val nickName = userRepository.getNickname()
        val interest = userRepository.getInterest()

        val category = when (interest) {
            Interests.RECYCLE -> "재활용의 여정"
            Interests.CLIMATE -> "기후의 변화"
            Interests.ENDANGERED -> "멸종위기"
        }

        return quizDataSource.getQuizList(nickName, category).toResult(
            transform = { it.data.quizResponses.map { quiz -> quiz.toQuiz() } }
        )
    }
}