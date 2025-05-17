package com.hiearth.fullquiz.feature.quiz.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hiearth.fullquiz.core.designsystem.theme.AppColors
import com.hiearth.fullquiz.core.model.Interests

@Composable
internal fun QuizHeader(
    interests: Interests,
    closeQuiz: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = interests.displayName,
            style = MaterialTheme.typography.displayMedium,
            color = AppColors.Black
        )
        IconButton(
            onClick = closeQuiz,
            modifier = Modifier.size(24.dp)
        ) {
            Icon(
                modifier = Modifier.size(18.dp),
                imageVector = Icons.Default.Close,
                contentDescription = "로고",
                tint = AppColors.Black
            )
        }
    }
}