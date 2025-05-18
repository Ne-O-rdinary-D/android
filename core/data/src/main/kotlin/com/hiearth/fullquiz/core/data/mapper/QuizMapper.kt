package com.hiearth.fullquiz.core.data.mapper

import com.hiearth.fullquiz.core.model.Answer
import com.hiearth.fullquiz.core.model.Quiz
import com.hiearth.fullquiz.core.model.QuizListDataSet
import com.hiearth.fullquiz.core.model.QuizType
import com.hiearth.fullquiz.core.network.model.response.QuizItem
import com.hiearth.fullquiz.core.network.model.response.QuizProgressResponse
import com.hiearth.fullquiz.core.network.model.response.QuizResponses

internal fun QuizItem.toQuizDataSet(): QuizListDataSet =
    QuizListDataSet(
        progressId = this.quizProgressId,
        quizList = this.quizResponses.map { it.toQuiz() }
    )

internal fun QuizResponses.toQuiz() = Quiz(
    quizId = id,
    quizType = enumValueOf<QuizType>(quizType),
    answer = enumValueOf<Answer>(answer),
    content = content,
    firstOption = firstOption,
    secondOption = secondOption,
    explanation = explanation
)

internal fun QuizProgressResponse.toQuizDataSet(): QuizListDataSet =
    QuizListDataSet(
        progressId = 0,
        quizList = this.data.map { it.toQuiz() }
    )