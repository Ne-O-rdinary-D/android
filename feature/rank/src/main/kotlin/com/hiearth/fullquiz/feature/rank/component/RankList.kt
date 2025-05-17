package com.hiearth.fullquiz.feature.rank.component

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.hiearth.fullquiz.core.designsystem.theme.MainGreen
import com.hiearth.fullquiz.feature.rank.model.RankData
import kotlin.math.abs

@Composable
fun RankList(
    rankList: List<RankData>,
    nickname: String
) {
    val listState = rememberLazyListState()

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
                val visibleFirstIndex = listState.firstVisibleItemIndex
                val widthFraction = (1.0f - (visibleFirstIndex - index) * 0.1f).coerceAtLeast(0.7f)

                val animatedWidth = animateDpAsState(
                    targetValue = (widthFraction * LocalConfiguration.current.screenWidthDp).dp,
                    label = ""
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .width(animatedWidth.value)
                        .align(Alignment.CenterHorizontally)
                ) {
                    RankBox(rankData, nickname)
                }
            }

        }
    }
}


@Composable
private fun RankBox(
    rankData: RankData,
    nickname: String
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
            .fillMaxWidth()
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
                .background(Color.White, shape = RoundedCornerShape(16.dp)) // 내부 내용 배경
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
fun calculateItemProgress(index: Int, listState: LazyListState): Float {
    val layoutInfo = listState.layoutInfo
    val itemInfo = layoutInfo.visibleItemsInfo.find { it.index == index } ?: return 1f

    val itemCenter = itemInfo.offset + itemInfo.size / 2
    val viewportCenter = layoutInfo.viewportStartOffset + layoutInfo.viewportEndOffset / 2

    val distance = abs(viewportCenter - itemCenter).toFloat()
    val maxDistance = layoutInfo.viewportEndOffset / 2f + itemInfo.size / 2f

    return (distance / maxDistance).coerceIn(0f, 1f)
}
