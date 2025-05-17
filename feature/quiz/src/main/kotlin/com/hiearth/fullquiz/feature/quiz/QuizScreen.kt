package com.hiearth.fullquiz.feature.quiz

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.hiearth.fullquiz.core.designsystem.theme.MainGreen
import com.hiearth.fullquiz.core.designsystem.theme.Typography
import com.hiearth.fullquiz.feature.quiz.model.QuizUiState

@Composable
internal fun QuizRoute(
    padding: PaddingValues,
    viewModel: QuizViewModel = hiltViewModel(),
    navigateHome: () -> Unit,
    navigateRanking: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    when (uiState) {
        is QuizUiState.Loading -> LoadingScreen()
        is QuizUiState.Success -> QuizScreen(
            padding = padding,
            navigateHome = navigateHome,
            navigateRanking = navigateRanking
        )
        is QuizUiState.Failure -> {}
    }
}

@Composable
private fun QuizScreen(
    padding: PaddingValues,
    navigateHome: () -> Unit = {},
    navigateRanking: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(padding)
            .padding(24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "퀴즈",
                style = MaterialTheme.typography.displayMedium
            )
        }

    }
}

@Composable
private fun LoadingScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_icon),
            contentDescription = "로고",
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "잠시만 기다려주세요",
            color = MainGreen,
            style = Typography.bodyMedium,
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "지구를 지켜가는 중이에요",
            color = MainGreen,
            style = Typography.bodyMedium,
        )
    }
}