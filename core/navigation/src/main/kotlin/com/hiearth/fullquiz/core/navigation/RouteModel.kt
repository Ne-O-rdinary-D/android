package com.hiearth.fullquiz.core.navigation

import kotlinx.serialization.Serializable
import org.junit.experimental.categories.Category

sealed interface Route {
    @Serializable
    data object IntroScreenRoute: Route

    @Serializable
    data class QuizScreenRoute(
        val quizCategory: String
    ): Route{
    }
}

sealed interface MainTabRoute : Route {
    @Serializable
    data object Home : MainTabRoute

    @Serializable
    data object Ranking : MainTabRoute

    @Serializable
    data object My : MainTabRoute
}

