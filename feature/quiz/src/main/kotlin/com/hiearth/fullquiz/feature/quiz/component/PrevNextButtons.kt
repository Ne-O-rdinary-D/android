package com.hiearth.fullquiz.feature.quiz.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hiearth.fullquiz.core.designsystem.theme.AppColors

@Composable
internal fun PrevNextButtons(
    quizIndex: Int = 0,
    onClickPrev: () -> Unit = {},
    onClickNext: () -> Unit = {},
    onClickComplete: () -> Unit = {}
) {
    val isLast = quizIndex == 4

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Button(
            modifier = Modifier
                .weight(1f),
            shape = RoundedCornerShape(8.dp),
            onClick = onClickPrev,
            colors = ButtonDefaults.buttonColors(
                containerColor = AppColors.Gray02
            )
        ) {
            Text(
                text = "이전 문제",
                style = MaterialTheme.typography.titleMedium,
                color = AppColors.Gray07,
            )
        }
        Button(
            modifier = Modifier
                .weight(1f),
            shape = RoundedCornerShape(8.dp),
            onClick = if (isLast) {
                onClickComplete
            } else {
                onClickNext
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary
            )
        ) {
            Text(
                text = if (isLast) {
                    "퀴즈 완료"
                } else {
                    "다음 단계"
                },
                style = MaterialTheme.typography.titleMedium.copy(
                    color = AppColors.White,
                ),
            )
        }
    }
}