package com.hiearth.fullquiz.feature.rank.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.hiearth.fullquiz.core.designsystem.theme.AppColors
import com.hiearth.fullquiz.feature.rank.R

@Composable
fun NicknameRow(
    userName: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_title),
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            tint = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.width(8.dp))
        TitleText(userName = userName)
    }
}

@Composable
private fun TitleText(
    userName: String
) {
    Text(
        buildAnnotatedString {
            withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary)) {
                append(userName)
            }
            withStyle(style = SpanStyle(color = AppColors.Black)) {
                append("님, 반가워요!")
            }
        },
        style = MaterialTheme.typography.displayMedium
    )
}
