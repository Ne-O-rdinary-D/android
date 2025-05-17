package com.hiearth.fullquiz.feature.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hiearth.fullquiz.core.designsystem.R
import com.hiearth.fullquiz.core.designsystem.theme.AppColors
import com.hiearth.fullquiz.core.designsystem.util.shadow

@Composable
internal fun HomeRankingCard(
    navigateRanking: () -> Unit = {}
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
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            RankingImage()
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                onClick = navigateRanking,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.secondary
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
private fun RankingImage() {
    Box(
        modifier = Modifier
            .height(120.dp)
            .fillMaxWidth(0.5f),
        contentAlignment = Alignment.BottomCenter
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .align(Alignment.BottomCenter)
                .clip(RoundedCornerShape(12.dp))
                .background(MaterialTheme.colorScheme.surfaceVariant)
        )
        Icon(
            painter = painterResource(com.hiearth.fullquiz.feature.home.R.drawable.ic_logo),
            contentDescription = null,
            modifier = Modifier.size(82.dp),
            tint = Color.Unspecified
        )
    }
}

@Preview
@Composable
private fun HomeQuizCardPreview() {
    HomeQuizCard()
}