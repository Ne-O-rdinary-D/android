package com.hiearth.fullquiz.feature.home

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hiearth.fullquiz.core.designsystem.R
import com.hiearth.fullquiz.core.designsystem.theme.AppColors
import com.hiearth.fullquiz.core.designsystem.util.shadow

@Composable
internal fun HomeQuizCard(
    currentStep: Int = 2,
    navigateQuiz: () -> Unit = {}
) {
    Card(
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .fillMaxWidth()
            .shadow(
                color = AppColors.Black.copy(alpha = 0.08f),
                blur = 9.dp,
            )
    ) {
        Column(
            modifier = Modifier
                .background(AppColors.White)
                .padding(16.dp)
        ) {
            Text(
                text = stringResource(R.string.string_quizing),
                style = MaterialTheme.typography.titleSmall.copy(
                    color = MaterialTheme.colorScheme.primary,
                ),
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(R.string.string_homequiz_description),
                style = MaterialTheme.typography.displayMedium.copy(
                    color = AppColors.Black,
                ),
            )
            Spacer(modifier = Modifier.height(24.dp))
            QuizStepIndicator(currentStep = currentStep)
            Spacer(modifier = Modifier.height(24.dp))
            Button(
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                onClick = navigateQuiz,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            ) {
                Text(
                    text = stringResource(R.string.string_continue_quiz),
                    style = MaterialTheme.typography.titleMedium.copy(
                        color = AppColors.White,
                    ),
                )
            }
        }
    }
}

@Composable
fun QuizStepIndicator(
    currentStep: Int
) {
    val stepsText = listOf("재활용 예정", "분리배출", "재활용 장소", "재활용 결과")
    val stepsColor = listOf(
        MaterialTheme.colorScheme.primary,
        Color(0xFF00ACFD),
        Color(0xFF247AF3),
        Color(0xFF006AFF)
    )
    val inactiveColor = Color(0xFFD9D9D9)

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        stepsText.forEachIndexed { index, title ->
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .height(4.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(2.dp))
                        .background(if (index <= currentStep) stepsColor[index] else inactiveColor)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = title,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = if (index <= currentStep) stepsColor[index] else inactiveColor,
                    ),
                )
            }
        }
    }
}

@Preview
@Composable
private fun HomeQuizCardPreview() {
    HomeQuizCard()
}