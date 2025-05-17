package com.hiearth.fullquiz.feature.rank

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.hiearth.fullquiz.feature.rank.component.BlurBox
import com.hiearth.fullquiz.feature.rank.component.NicknameRow
import com.hiearth.fullquiz.feature.rank.component.RankList
import com.hiearth.fullquiz.feature.rank.component.SummaryBox
import com.hiearth.fullquiz.feature.rank.model.RankUiState

@Composable
fun RankRoute(
    padding: PaddingValues,
    viewModel: RankViewModel = hiltViewModel()
) {
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.load()
    }

    RankScreen(
        padding = padding,
        uiState = uiState.value,
        reLoad = {
            viewModel.load()
        }
    )
}

@Composable
private fun RankScreen(
    padding: PaddingValues,
    uiState: RankUiState,
    reLoad: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
            .background(MaterialTheme.colorScheme.background)
    ) {
        if (uiState is RankUiState.Loading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
        ) {
            when (uiState) {
                is RankUiState.Failure -> {}
                RankUiState.Init -> {}
                RankUiState.Loading -> {}
                is RankUiState.Success -> {
                    NicknameRow(uiState.nickname)

                    Spacer(modifier = Modifier.height(24.dp))

                    SummaryBox(uiState.myRankData)

                    Spacer(modifier = Modifier.height(24.dp))

                    RankList(
                        uiState.rankList, uiState.nickname,
                        reLoad = { reLoad() }
                    )
                }
            }
        }

        BlurBox(
            modifier = Modifier
                .align(Alignment.BottomCenter)
        )
    }
}
