package com.hiearth.fullquiz.feature.main

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import com.hiearth.fullquiz.core.navigation.MainTabRoute
import com.hiearth.fullquiz.core.navigation.Route

enum class MainTab(
    @DrawableRes
    val iconResId: Int,
    internal val contentDescription: String,
    val route: MainTabRoute
) {
    RANKING(
        iconResId = R.drawable.ic_ranking,
        contentDescription = "랭킹",
        route = MainTabRoute.Ranking,
    ),
    HOME(
        iconResId = R.drawable.ic_home,
        contentDescription = "홈",
        route = MainTabRoute.Home,
    ),
    MY(
        iconResId = R.drawable.ic_my,
        contentDescription = "마이",
        route = MainTabRoute.My,
    );

    companion object {
        @Composable
        fun find(predicate: @Composable (MainTabRoute) -> Boolean): MainTab? {
            return entries.find { predicate(it.route) }
        }

        @Composable
        fun contains(predicate: @Composable (Route) -> Boolean): Boolean {
            return entries.map { it.route }.any { predicate(it) }
        }
    }
}