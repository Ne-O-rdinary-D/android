package com.hiearth.fullquiz.feature.home.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.hiearth.fullquiz.core.navigation.MainTabRoute
import com.hiearth.fullquiz.feature.home.HomeRoute

fun NavController.navigateHome(
    navOptions: NavOptions
) {
    navigate(MainTabRoute.Home, navOptions)
}

fun NavGraphBuilder.homeNavGraph(
    padding: PaddingValues,
    navigateRanking: () -> Unit
) {
    composable<MainTabRoute.Home> {
        HomeRoute(
            padding = padding,
            navigateRanking = navigateRanking
        )
    }
}