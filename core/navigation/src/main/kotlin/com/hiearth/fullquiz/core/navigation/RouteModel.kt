package com.hiearth.fullquiz.core.navigation

import kotlinx.serialization.Serializable

sealed interface Route {
//    @Serializable
//    data object Setting : Route
//
//    @Serializable
//    data class Detail(val id: String) : Route
}

sealed interface MainTabRoute : Route {
    @Serializable
    data object Home : MainTabRoute

    @Serializable
    data object Ranking : MainTabRoute

    @Serializable
    data object My : MainTabRoute
}