package com.hiearth.fullquiz.core.designsystem.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val LightColorScheme = lightColorScheme(
    primary = MainGreen,
    onPrimary = Color.White,

    secondary = PointBlue,
    onSecondary = Color.White,

    background = Background,
    onBackground = Color.Black,

    surface = Background,
    onSurface = Color.Black,

    surfaceVariant = SubBlue, // 카드용 배경 등
    onSurfaceVariant = Color.Black,

    tertiaryContainer = SUbGreen,
    onTertiaryContainer = Color.Black
)

@Composable
fun FullQuizTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = Typography,
        content = content
    )
}