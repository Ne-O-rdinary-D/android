package com.hiearth.fullquiz.feature.main.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.hiearth.fullquiz.feature.main.MainNavigator
import com.hiearth.fullquiz.feature.main.MainTab
import com.hiearth.fullquiz.feature.nickname.navigation.introNavGraph

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
//            homeNavGraph(
//                padding = padding
//            )
            introNavGraph(
                padding = padding,
                navigateToHome = {navigator.navigate(MainTab.HOME)}
            )
        }
    }
}