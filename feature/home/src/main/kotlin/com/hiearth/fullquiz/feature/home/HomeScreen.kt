package com.hiearth.fullquiz.feature.home

import androidx.compose.foundation.ScrollState
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.hiearth.fullquiz.core.designsystem.theme.AppColors
import com.hiearth.fullquiz.feature.home.component.HomeQuizCard
import com.hiearth.fullquiz.feature.home.component.HomeRankingCard
import com.hiearth.fullquiz.feature.home.model.HomeUiState

@Composable
internal fun HomeRoute(
    padding: PaddingValues,
    viewModel: HomeViewModel = hiltViewModel(),
    navigateRanking: () -> Unit
) {
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()
    val userName = viewModel.nickName
    val scrollState = rememberScrollState()

    HomeScreen(
        padding = padding,
        uiState = uiState.value,
        userName = userName,
        scrollState = scrollState,
        navigateRanking = { navigateRanking() }
    )
}

@Composable
private fun HomeScreen(
    padding: PaddingValues,
    uiState: HomeUiState = HomeUiState.Init,
    userName: String = "지구모아",
    currentStep: Int = 0,
    scrollState: ScrollState = rememberScrollState(),
    navigateQuiz: () -> Unit = {},
    navigateRanking: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(padding)
            .padding(top = 24.dp, start = 24.dp, end = 24.dp)
            .fillMaxSize()
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_title),
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                tint = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.width(8.dp))
            TitleText(userName = userName)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "나의 현황",
            style = MaterialTheme.typography.displayMedium.copy(
                color = AppColors.Black,
            ),
        )
        HomeQuizCard(
            currentStep = currentStep,
            navigateQuiz = navigateQuiz
        )
        Text(
            text = "나의 랭킹 순위는?",
            style = MaterialTheme.typography.displayMedium.copy(
                color = AppColors.Black,
            ),
        )
        HomeRankingCard(
            navigateRanking = navigateRanking
        )
    }
}

@Composable
private fun TitleText(
    userName: String
) {
    Text(
        buildAnnotatedString {
            withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary)) {
                append(userName)
            }
            withStyle(style = SpanStyle(color = AppColors.Black)) {
                append(stringResource(R.string.string_hi))
            }
        },
        style = MaterialTheme.typography.displayMedium
    )
}

@Preview(showBackground = true, backgroundColor = 0xFFF6F6F6)
@Composable
private fun HomeScreenPreview() {
    HomeScreen(
        padding = PaddingValues(0.dp),
    )
}
