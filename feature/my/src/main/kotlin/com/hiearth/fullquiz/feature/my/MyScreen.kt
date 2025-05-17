package com.hiearth.fullquiz.feature.my

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
import com.hiearth.fullquiz.feature.my.component.ChapterStatusList
import com.hiearth.fullquiz.feature.my.component.NicknameRow
import com.hiearth.fullquiz.feature.my.model.MyUiState

@Composable
fun MyRoute(
    padding: PaddingValues,
    viewModel: MyViewModel = hiltViewModel()
) {
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()

    MyScreen(
        padding,
        uiState.value
    )
}

@Composable
private fun MyScreen(
    padding: PaddingValues,
    uiState: MyUiState
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(padding)
            .padding(24.dp)

    ) {
        when (uiState) {
            is MyUiState.Failure -> {}
            MyUiState.Init -> {}
            MyUiState.Loading -> {}
            is MyUiState.Success -> {
                NicknameRow(uiState.nickname)
                Spacer(modifier = Modifier.height(40.dp))

                uiState.chapterStatusList.forEach {
                    ChapterStatusList(it)
                    Spacer(Modifier.height(24.dp))
                }
            }
        }
    }
}