package com.example.composebaseproject.feature.home.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.composebaseproject.core.navigation.MainTabRoute
import com.example.composebaseproject.feature.home.HomeRoute

fun NavController.navigateHome(navOptions: NavOptions) {
    navigate(MainTabRoute.Home, navOptions)
}

fun NavGraphBuilder.homeNavGraph(
    padding: PaddingValues
) {
    composable<MainTabRoute.Home> {
        HomeRoute(
            padding = padding
        )
    }
}