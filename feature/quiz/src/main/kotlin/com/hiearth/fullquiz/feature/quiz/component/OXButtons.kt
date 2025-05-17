package com.hiearth.fullquiz.feature.quiz.component

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.hiearth.fullquiz.core.designsystem.theme.AppColors
import com.hiearth.fullquiz.core.model.Answer

@Composable
internal fun OXButtons(
    isAnswered: Boolean = false,
    userAnswer: Answer? = null,
    onSelect: (Answer) -> Unit = {}
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        listOf(Answer.O, Answer.X).forEach { value ->
            val isSelected = userAnswer == value

            Box(
                modifier = Modifier
                    .weight(1f)
                    .aspectRatio(1f)
                    .clip(RoundedCornerShape(12.dp))
                    .background(AppColors.Gray02)
                    .then(
                        if (isSelected && isAnswered) Modifier.border(
                            width = 2.dp,
                            brush = Brush.horizontalGradient(
                                listOf(
                                    MaterialTheme.colorScheme.primary,
                                    MaterialTheme.colorScheme.secondary
                                )
                            ),
                            shape = RoundedCornerShape(12.dp)
                        ) else Modifier
                    )
                    .let { base ->
                        if (!isAnswered) base.clickable { onSelect(value) } else base
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = value.label,
                    style = MaterialTheme.typography.titleLarge,
                    color = if(isSelected) AppColors.Gray07 else AppColors.Gray04,
                )
            }
        }
    }
}