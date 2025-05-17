package com.hiearth.fullquiz.core.data.mapper

import com.hiearth.fullquiz.core.model.Quiz
import com.hiearth.fullquiz.core.network.model.response.QuizResponse

internal fun QuizResponse.toQuiz(): Quiz =
    Quiz(
        quizId = quizId,
        quizType = quizType,
        answer = answer,
        content = content,
        firstOption = firstOption,
        secondOption = secondOption,
        explanation = explanation
    )