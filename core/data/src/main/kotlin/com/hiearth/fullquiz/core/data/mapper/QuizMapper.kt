package com.hiearth.fullquiz.core.data.mapper

import com.hiearth.fullquiz.core.model.Answer
import com.hiearth.fullquiz.core.model.Quiz
import com.hiearth.fullquiz.core.model.QuizType
import com.hiearth.fullquiz.core.network.model.response.QuizResponses

internal fun QuizResponses.toQuiz(): Quiz =
    Quiz(
        quizId = id,
        quizType = enumValueOf<QuizType>(quizType),
        answer = enumValueOf<Answer>(answer),
        content = content,
        firstOption = firstOption,
        secondOption = secondOption,
        explanation = explanation
    )