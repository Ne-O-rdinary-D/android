package com.hiearth.fullquiz.feature.rank.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.hiearth.fullquiz.core.navigation.MainTabRoute
import com.hiearth.fullquiz.feature.rank.RankRoute

fun NavController.navigateRank(navOptions: NavOptions) {
    navigate(MainTabRoute.Ranking, navOptions)
}

fun NavGraphBuilder.rankNavGraph(
    padding: PaddingValues,
) {
    composable<MainTabRoute.Ranking> {
        RankRoute(
            padding = padding,
        )
    }
}