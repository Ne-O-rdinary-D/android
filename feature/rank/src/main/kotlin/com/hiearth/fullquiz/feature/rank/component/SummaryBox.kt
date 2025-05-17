package com.hiearth.fullquiz.feature.rank.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hiearth.fullquiz.core.designsystem.theme.MainGreen
import com.hiearth.fullquiz.core.model.RankData

@Composable
fun SummaryBox(
    myRankData: RankData
) {
    val interfaceList = listOf(
        "현재 순위" to myRankData.rank,
        "정답 수" to myRankData.correctProblem,
        "오답 수" to myRankData.incorrectProblem
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .shadow(1.dp, RoundedCornerShape(12.dp))
            .clip(RoundedCornerShape(12.dp))
            .background(Color.White)
            .padding(vertical = 16.dp, horizontal = 12.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            interfaceList.forEachIndexed { index, item ->
                SummaryItem(
                    title = item.first,
                    value = if (item.first == "현재 순위") item.second.toString() + "위" else item.second.toString(),
                    valueColor = if (item.first == "현재 순위") MainGreen else Color.Gray
                )
                if (index != interfaceList.lastIndex) {
                    VerticalDivider(
                        modifier = Modifier
                            .height(32.dp),
                        color = Color.Gray,
                        thickness = 1.dp
                    )
                }
            }
        }
    }
}


@Composable
private fun SummaryItem(
    title: String,
    value: String,
    valueColor: Color = Color.Gray
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            color = Color.Gray,
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = value,
            color = valueColor,
            style = MaterialTheme.typography.displayMedium
        )
    }
}

@Preview
@Composable
private fun SummaryBox() {
    SummaryBox(myRankData = RankData("",1, 1, 1))
}
