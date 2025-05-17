package com.hiearth.fullquiz.feature.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.hiearth.fullquiz.core.navigation.MainTabRoute
import com.hiearth.fullquiz.core.navigation.Route
import com.hiearth.fullquiz.feature.home.navigation.navigateHome
import com.hiearth.fullquiz.feature.quiz.navigation.navigateQuiz
import com.hiearth.fullquiz.feature.my.navigation.navigateMy
import com.hiearth.fullquiz.feature.rank.navigation.navigateRank

class MainNavigator(
    val navController: NavHostController
) {
    private val currentDestination: NavDestination?
        @Composable get() = navController.currentBackStackEntryAsState().value?.destination

    val startDestination: Route = Route.IntroScreenRoute

    val currentTab: MainTab?
        @Composable get() = MainTab.find { tab ->
            currentDestination?.hasRoute(tab::class) == true
        }

    private val singleTopOptions = navOptions {
        launchSingleTop = false
        restoreState = true
    }

    fun navigate(tab: MainTab) {
        val navOptions = navOptions {
            popUpTo(navController.graph.findStartDestination().id) {
                inclusive = true  // -> Intro/Quiz 백스택에서 제거됨
            }
            launchSingleTop = true
        }

        when (tab) {
            MainTab.HOME -> navController.navigateHome(navOptions)
            MainTab.RANKING -> navController.navigateRank(navOptions)
            MainTab.MY -> navController.navigateMy(navOptions)
        }
    }

    fun navigateQuizWithCategory(quizCategory: String) {
        navController.navigateQuiz(singleTopOptions, quizCategory)
    }


    fun navigateQuiz() {
        navController.navigateQuiz(singleTopOptions)
    }
    private fun popBackStack() {
        navController.popBackStack()
    }

    fun popBackStackIfNotHome() {
        if (!isSameCurrentDestination<MainTabRoute.Home>()) {
            popBackStack()
        }
    }

    private inline fun <reified T : Route> isSameCurrentDestination(): Boolean {
        return navController.currentDestination?.hasRoute<T>() == true
    }

    @Composable
    fun shouldShowBottomBar() = MainTab.contains {
        currentDestination?.hasRoute(it::class) == true
    }
}

@Composable
internal fun rememberMainNavigator(
    navController: NavHostController = rememberNavController(),
): MainNavigator = remember(navController) {
    MainNavigator(navController)
}