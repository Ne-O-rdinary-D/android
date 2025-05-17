package com.hiearth.fullquiz.feature.nickname.component

import android.window.SplashScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hiearth.fullquiz.core.designsystem.theme.MainGreen
import com.hiearth.fullquiz.core.designsystem.theme.Typography
import com.hiearth.fullquiz.feature.intro.R

@Composable
fun SplashScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_icon),
            contentDescription = "로고",
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "풀퀴즈",
            color = MainGreen,
            style = Typography.displayLarge,
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "지구를 지키는 작은 실천 지금 시작됩니다!",
            color = MainGreen,
            style = Typography.bodyMedium,
        )
    }
}

@Composable
@Preview
private fun SplashScreenPrev(){
    SplashScreen()
}