package com.hiearth.fullquiz.feature.main.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import com.hiearth.fullquiz.feature.home.navigation.homeNavGraph
import com.hiearth.fullquiz.feature.main.MainNavigator
import com.hiearth.fullquiz.feature.main.MainTab
import com.hiearth.fullquiz.feature.nickname.navigation.introNavGraph
import com.hiearth.fullquiz.feature.quiz.navigation.quizNavGraph

@Composable
internal fun MainNavHost(
    modifier: Modifier = Modifier,
    navigator: MainNavigator,
    padding: PaddingValues,
    onShowErrorSnackBar: (throwable: Throwable?) -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        NavHost(
            navController = navigator.navController,
            startDestination = navigator.startDestination,
        ) {
            homeNavGraph(
                padding = padding
            )
            introNavGraph(
                padding = padding,
                navigateQuiz = navigator::navigateQuiz
            )
            quizNavGraph(
                padding = padding,
                navigateHome = { navigator.navigate(MainTab.HOME) },
                navigateRanking = { navigator.navigate(MainTab.RANKING) }
            )
        }
    }
}