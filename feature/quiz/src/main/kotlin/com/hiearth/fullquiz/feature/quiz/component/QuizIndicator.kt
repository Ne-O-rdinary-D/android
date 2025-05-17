package com.hiearth.fullquiz.feature.quiz.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.hiearth.fullquiz.core.designsystem.theme.AppColors

@Composable
internal fun QuizIndicator(
    currentStep: Int = 0
) {
    val activeColor = MaterialTheme.colorScheme.primary
    val inactiveColor = AppColors.Gray02

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        for(index in 0..4) {
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .height(4.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(2.dp))
                        .background(if (index <= currentStep) activeColor else inactiveColor)
                )
            }
        }
    }
}