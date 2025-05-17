package com.hiearth.fullquiz.feature.my.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hiearth.fullquiz.feature.my.R
import com.hiearth.fullquiz.feature.my.model.ChapterStatusData
import com.hiearth.fullquiz.feature.my.model.ChapterStatusType

@Composable
fun ChapterStatusList(
    chapterStatusData: ChapterStatusData,
    navigateChapter: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = getTitleString(chapterStatusData),
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(12.dp))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(chapterStatusData.chapterStatusList) { status ->
                ChapterStatusBox(status, navigateChapter = navigateChapter)
            }
        }
    }
}


@Composable
fun ChapterStatusBox(
    status: ChapterStatusType,
    title: String = "재활용 여정",
    navigateChapter: () -> Unit
) {
    val icon = when (status) {
        ChapterStatusType.COMPLETE -> painterResource(R.drawable.ic_completed)
        ChapterStatusType.NOT_STARTED -> painterResource(R.drawable.ic_not_started)
        ChapterStatusType.IN_PROGRESS -> painterResource(R.drawable.ic_in_progress)
    }

    Column(
        modifier = Modifier
            .width(130.dp)
            .height(130.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Color.White)
            .clickable { navigateChapter() },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = icon,
            contentDescription = null,
            modifier = Modifier
                .width(31.dp)
                .height(31.dp),
            tint = Color.Unspecified
        )

        Spacer(Modifier.height(24.dp))

        Text(
            text = title,
            color = Color.Black,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}


private fun getTitleString(chapterStatusData: ChapterStatusData): String {
    val completedCount =
        chapterStatusData.chapterStatusList.count { it == ChapterStatusType.COMPLETE }
    val totalCount = chapterStatusData.chapterStatusList.size
    return "${chapterStatusData.type.displayName} ($completedCount/$totalCount)"
}


@Preview
@Composable
private fun ChapterStatusBoxPrev() {
    ChapterStatusBox(status = ChapterStatusType.COMPLETE){}
}