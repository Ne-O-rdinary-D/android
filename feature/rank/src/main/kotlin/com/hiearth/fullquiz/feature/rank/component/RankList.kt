package com.hiearth.fullquiz.feature.rank.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.hiearth.fullquiz.core.designsystem.theme.MainGreen
import com.hiearth.fullquiz.feature.rank.model.RankData

@Composable
fun RankList(
    rankList: List<RankData>,
    nickname:String
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "순위 목록",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(24.dp))

        LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            items(rankList) { rankData ->
                RankBox(rankData, nickname)
            }
        }
    }
}


@Composable
private fun RankBox(rankData: RankData, nickname: String) {
    val isMine = rankData.nickname == nickname
    val border = if (isMine) BorderStroke(1.5.dp, MainGreen) else null

    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        color = Color.White,
        border = border
    ) {
        Row(
            modifier = Modifier
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


