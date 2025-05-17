package com.hiearth.fullquiz.core.network.retrofit

import com.hiearth.fullquiz.core.model.Answer
import com.hiearth.fullquiz.core.model.Quiz
import com.hiearth.fullquiz.core.model.QuizType
import com.hiearth.fullquiz.core.network.datasource.QuizDataSource
import com.hiearth.fullquiz.core.network.datasource.UserDataSource
import com.hiearth.fullquiz.core.network.model.ApiResponse
import com.hiearth.fullquiz.core.network.model.response.QuizResponse
import com.hiearth.fullquiz.core.network.model.response.UserResponse
import kotlinx.coroutines.delay
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class FakeQuizDataSource @Inject constructor(

) : QuizDataSource {

    override suspend fun getQuizList(): ApiResponse<List<QuizResponse>> {
        return ApiResponse.Success(
            mutableListOf(
                QuizResponse(
                    quizId = 1,
                    quizType = QuizType.AB,
                    answer = Answer.A,
                    content = "examplasdeddd",
                    firstOption = "A에 대한 설명",
                    secondOption = "B에 대한 설명",
                    explanation = "explanation\nexplanation\nexplanation\nexplanation"
                ),
                QuizResponse(
                    quizId = 2,
                    quizType = QuizType.OX,
                    answer = Answer.O,
                    content = "example",
                    firstOption = "O",
                    secondOption = "X",
                    explanation = "explanation\nexplanation\nexplanation\nexplanation"
                ),
                QuizResponse(
                    quizId = 3,
                    quizType = QuizType.OX,
                    answer = Answer.X,
                    content = "examplasdasde",
                    firstOption = "O",
                    secondOption = "X",
                    explanation = "explanaddtion\nexplanation\nexplanation\nexplanation"
                ),
                QuizResponse(
                    quizId = 4,
                    quizType = QuizType.AB,
                    answer = Answer.B,
                    content = "example",
                    firstOption = "A에 대한 설명",
                    secondOption = "B에 대한 설명",
                    explanation = "explanation\nexplanation\nexplanation\nexplanation"
                ),
                QuizResponse(
                    quizId = 5,
                    quizType = QuizType.OX,
                    answer = Answer.O,
                    content = "example",
                    firstOption = "O",
                    secondOption = "X",
                    explanation = "explanation\nexplanation\nexplanation\nexplanation"
                ),

            )
        )
    }
}