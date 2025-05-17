package com.hiearth.fullquiz.feature.quiz

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.hiearth.fullquiz.core.navigation.Route

fun NavController.navigateQuiz(navOptions: NavOptions) {
    navigate(Route.QuizScreenRoute, navOptions)
}

fun NavGraphBuilder.quizNavGraph(
    padding: PaddingValues,
    navigateHome: () -> Unit,
    navigateRanking: () -> Unit
) {
    composable<Route.QuizScreenRoute> {

    }
}