package com.hiearth.fullquiz.core.data

import com.hiearth.fullquiz.core.data.mapper.toQuiz
import com.hiearth.fullquiz.core.data.mapper.toQuizDataSet
import com.hiearth.fullquiz.core.data.mapper.toResult
import com.hiearth.fullquiz.core.model.Interests
import com.hiearth.fullquiz.core.model.Quiz
import com.hiearth.fullquiz.core.model.QuizListDataSet
import com.hiearth.fullquiz.core.network.datasource.QuizDataSource
import javax.inject.Inject

class QuizRepositoryImpl @Inject constructor(
    private val userRepository: UserRepository,
    private val quizDataSource: QuizDataSource
) : QuizRepository {
    override suspend fun getQuizList(): Result<QuizListDataSet> {
        val nickName = userRepository.getNickname()
        val interest = userRepository.getInterest()

        val category = when (interest) {
            Interests.RECYCLE -> "재활용의 여정"
            Interests.CLIMATE -> "기후의 변화"
            Interests.ENDANGERED -> "멸종위기"
        }


        return quizDataSource.getQuizList(nickName, category).toResult(
            transform = {
                val progressList = userRepository.getProgressIdList()
                val newProgressList = progressList + (category to it.data.quizProgressId)

                userRepository.setProgressIdList(newProgressList)
                it.data.toQuizDataSet()
            }
        )
    }

    override suspend fun getQuizList(category: String): Result<QuizListDataSet> {
        val nickName = userRepository.getNickname()

        return quizDataSource.getQuizList(nickName, category).toResult(
            transform = {
                val progressList = userRepository.getProgressIdList()
                val newProgressList = progressList + (category to it.data.quizProgressId)

                userRepository.setProgressIdList(newProgressList)

                it.data.toQuizDataSet()
            }
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

    override suspend fun getProgressQuiz(quizProgressId: Long): Result<QuizListDataSet> {
        return quizDataSource.getProgressQuiz(quizProgressId).toResult(
            transform = { it.toQuizDataSet() }
        )
    }
}
