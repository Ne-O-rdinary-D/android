package com.hiearth.fullquiz.feature.my.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.hiearth.fullquiz.core.navigation.MainTabRoute
import com.hiearth.fullquiz.feature.my.MyRoute

fun NavController.navigateMy(navOptions: NavOptions) {
    navigate(MainTabRoute.My, navOptions)
}

fun NavGraphBuilder.myNavGraph(
    padding: PaddingValues,
    navigateQuiz: (String) -> Unit
) {
    composable<MainTabRoute.My> {
        MyRoute(
            padding = padding,
            navigateQuiz = navigateQuiz
        )
    }
}