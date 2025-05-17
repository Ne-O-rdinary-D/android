package com.hiearth.fullquiz.feature.rank

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
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


    RankScreen(
        padding = padding,
        uiState = uiState.value
    )
}

@Composable
private fun RankScreen(
    padding: PaddingValues,
    uiState: RankUiState
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
            .background(MaterialTheme.colorScheme.background)
            .padding(top = 24.dp, start = 24.dp, end = 24.dp)
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

                RankList(uiState.rankList, uiState.nickname)
            }
        }

    }
}