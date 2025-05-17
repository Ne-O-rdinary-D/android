package com.hiearth.fullquiz.feature.nickname.component

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hiearth.fullquiz.core.designsystem.theme.MainGreen

@Composable
internal fun NextButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
) {
    Button(
        onClick = { onClick() },
        modifier = modifier.height(60.dp),
        colors = ButtonDefaults.buttonColors(containerColor = MainGreen),
        shape = RoundedCornerShape(12.dp),
    ) {
        Text(text, color = Color.White, style = MaterialTheme.typography.bodyLarge)
    }
}

@Composable
@Preview
private fun NextButtonPrev(){
    NextButton(text = "다음") { }
}