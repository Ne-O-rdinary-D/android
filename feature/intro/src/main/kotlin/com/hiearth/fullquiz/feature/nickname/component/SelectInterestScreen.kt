package com.hiearth.fullquiz.feature.nickname.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hiearth.fullquiz.core.designsystem.theme.MainGreen
import com.hiearth.fullquiz.core.designsystem.theme.Typography
import com.hiearth.fullquiz.core.model.Interests
import com.hiearth.fullquiz.feature.intro.R

@Composable
internal fun SelectInterestScreen(
    selected: Interests?,
    onSelect: (Interests) -> Unit,
    onBackClick: () -> Unit
) {
    val interestList = listOf(
        Interests.RECYCLE to R.drawable.ic_recycling,
        Interests.CLIMATE to R.drawable.ic_climate,
        Interests.ENDANGERED to R.drawable.ic_endangered
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
    ) {
        Spacer(modifier = Modifier.height(20.dp))

        IconButton(onClick = { onBackClick() }) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "뒤로가기"
            )
        }

        Spacer(modifier = Modifier.height(48.dp))

        Text(
            text = "관심 있는 환경 문제를\n선택해주세요!",
            style = MaterialTheme.typography.displayLarge,
            textAlign = TextAlign.Start
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "선택한 환경 문제부터 퀴즈를 풀 수 있어요!",
            style = MaterialTheme.typography.displayMedium,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(24.dp))

        interestList.forEach { (interest, iconRes) ->
            SelectInterestBox(
                interest = interest,
                iconRes = iconRes,
                isSelected = selected == interest,
                onClick = { onSelect(interest) }
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
private fun SelectInterestBox(
    interest: Interests,
    @DrawableRes iconRes: Int,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val borderColor = if (isSelected) MainGreen else Color.Transparent

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(
                elevation = 6.dp,
                shape = RoundedCornerShape(16.dp),
                clip = false // 배경과 별도로 그림자만 줄 때
            )
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
            .border(
                width = 2.dp,
                color = borderColor,
                shape = RoundedCornerShape(16.dp)
            )
            .clickable { onClick() }
            .padding(vertical = 24.dp),
        contentAlignment = Alignment.Center
    ) {
            Image(
                painter = painterResource(id = iconRes),
                contentDescription = interest.displayName,
            )
    }
}


@Composable
@Preview
private fun SelectInterestScreenPrev(){
    SelectInterestScreen(
        selected = null,
        onSelect = {  },
        onBackClick = {  }
    )
}