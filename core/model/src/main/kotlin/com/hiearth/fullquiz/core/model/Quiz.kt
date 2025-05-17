package com.hiearth.fullquiz.core.model

data class Quiz(
    val currentStep: Int = 0,
    val question: String = "",
    val quizType: QuizType = QuizType.SINGLE,
)

enum class QuizType {
    SINGLE,
    MULTIPLE,
}
