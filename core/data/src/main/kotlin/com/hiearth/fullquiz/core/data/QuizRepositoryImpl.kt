package com.hiearth.fullquiz.core.data

import com.hiearth.fullquiz.core.data.mapper.toQuiz
import com.hiearth.fullquiz.core.data.mapper.toResult
import com.hiearth.fullquiz.core.model.Interests
import com.hiearth.fullquiz.core.model.Quiz
import com.hiearth.fullquiz.core.network.datasource.QuizDataSource
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

    override suspend fun getQuizList(category: String): Result<List<Quiz>> {
        val nickName = userRepository.getNickname()

        return quizDataSource.getQuizList(nickName, category).toResult(
            transform = { it.data.quizResponses.map { quiz -> quiz.toQuiz() } }
        )
    }

    override suspend fun postCurrentQuiz(
        quizId: String,
        isCorrect: Boolean,
        userAnswer: String
    ): Result<Unit> {
        val nickName = userRepository.getNickname()
        return quizDataSource.postCurrentQuiz(nickName, quizId, isCorrect, userAnswer)
            .toResult()
    }
}
