package com.hiearth.fullquiz.feature.nickname.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.hiearth.fullquiz.core.navigation.Route
import com.hiearth.fullquiz.feature.nickname.IntroRoute

fun NavGraphBuilder.introNavGraph(
    padding: PaddingValues,
    navigateToHome: () -> Unit
) {
    composable<Route.IntroScreenRoute> {
        IntroRoute(
            padding = padding,
            navigateToHome = navigateToHome
        )
    }
}