package com.hiearth.fullquiz.feature.rank.component

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.hiearth.fullquiz.core.designsystem.theme.MainGreen
import com.hiearth.fullquiz.core.model.RankData

@Composable
fun RankList(
    rankList: List<RankData>,
    nickname: String,
    reLoad: () -> Unit
) {
    val listState = rememberLazyListState()
    var lastScrollOffset by remember { mutableStateOf(0) }

    LaunchedEffect(listState) {
        snapshotFlow { listState.firstVisibleItemScrollOffset }
            .collect { offset ->
                val isScrollingUp = offset < lastScrollOffset
                lastScrollOffset = offset

                if (
                    listState.firstVisibleItemIndex == 0 &&
                    offset == 0 &&
                    isScrollingUp
                ) {
                    reLoad()
                }
            }
    }

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "순위 목록",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(24.dp))

        LazyColumn(
            state = listState,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            itemsIndexed(rankList) { index, rankData ->
                val progress = calculateRelativeProgress(index, listState)
                val widthFraction = (1.0f - 0.3f * progress).coerceIn(0.7f, 1.0f)

                val animatedWidth = animateDpAsState(
                    targetValue = (widthFraction * LocalConfiguration.current.screenWidthDp).dp,
                    label = ""
                )

                val animatedHeight = animateDpAsState(
                    targetValue = (widthFraction * 100).dp,
                    label = ""
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    RankBox(rankData, nickname, animatedWidth.value, animatedHeight.value)
                }
            }

        }
    }
}


@Composable
private fun RankBox(
    rankData: RankData,
    nickname: String,
    width: Dp,
    height: Dp
) {
    val isMine = rankData.nickname == nickname
    val borderGradient = if (isMine) {
        Brush.horizontalGradient(
            colors = listOf(MainGreen, Color(0xFF2197FF))
        )
    } else {
        null
    }

    Box(
        modifier = Modifier
            .width(width)
            .padding(1.5.dp)
            .let {
                if (borderGradient != null) {
                    it.background(borderGradient, shape = RoundedCornerShape(16.dp))
                } else it
            }
            .padding(1.5.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(height)
                .background(Color.White, shape = RoundedCornerShape(16.dp))
                .padding(vertical = 8.dp, horizontal = 24.dp)
                .height(80.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "${rankData.rank}위",
                    style = MaterialTheme.typography.displayMedium,
                    color = if (isMine) MainGreen else Color.Black
                )

                Spacer(modifier = Modifier.width(20.dp))

                Text(
                    text = rankData.nickname,
                    style = MaterialTheme.typography.displayMedium
                )
            }

            Text(
                text = "정답 ${rankData.correctProblem}개",
                style = MaterialTheme.typography.displayMedium,
                color = Color.Black
            )
        }
    }

}


@Composable
fun calculateRelativeProgress(index: Int, listState: LazyListState): Float {
    val layoutInfo = listState.layoutInfo
    val itemInfo = layoutInfo.visibleItemsInfo.find { it.index == index } ?: return 1f

    val itemTop = itemInfo.offset
    val viewportHeight = layoutInfo.viewportEndOffset
    val relativeOffset = itemTop.toFloat() / viewportHeight.toFloat()

    return relativeOffset.coerceIn(0f, 1f) // 0f: 맨 위, 1f: 맨 아래
}

