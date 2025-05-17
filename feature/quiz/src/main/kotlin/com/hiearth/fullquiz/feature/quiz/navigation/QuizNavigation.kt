package com.hiearth.fullquiz.feature.quiz.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.hiearth.fullquiz.core.navigation.Route
import com.hiearth.fullquiz.feature.quiz.QuizRoute

fun NavController.navigateQuiz(
    navOptions: NavOptions,
    quizCategory: String = ""
) {
    navigate(Route.QuizScreenRoute(quizCategory), navOptions)
}

fun NavGraphBuilder.quizNavGraph(
    padding: PaddingValues,
    navigateHome: () -> Unit,
    navigateRanking: () -> Unit,
) {
    composable<Route.QuizScreenRoute> {
        QuizRoute(
            padding = padding,
            navigateHome = navigateHome,
            navigateRanking = navigateRanking,
            quizCategory = it.toRoute<Route.QuizScreenRoute>().quizCategory
        )
    }
}