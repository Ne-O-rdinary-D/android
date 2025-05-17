package com.hiearth.fullquiz.feature.quiz.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.hiearth.fullquiz.core.designsystem.theme.AppColors

@Composable
internal fun FullQuizDialog(
    title: String = "",
    description: String = "",
    @DrawableRes iconResId: Int? = null,
    dismissText: String = "",
    confirmText: String = "",
    onDismiss: () -> Unit = {},
    onConfirm: () -> Unit = {},
) {
    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = true,
        )
    ) {
        Card(
            shape = RoundedCornerShape(20.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .background(color = Color.White)
                    .padding(vertical = 24.dp, horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically)
            ) {
                iconResId?.let {
                    Icon(
                        imageVector = ImageVector.vectorResource(iconResId),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(56.dp)
                    )
                }

                Text(
                    style = MaterialTheme.typography.displayMedium,
                    textAlign = TextAlign.Center,
                    text = title,
                    color = AppColors.Black
                )

                Text(
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center,
                    text = description
                )

                TextButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(100.dp))
                        .background(MaterialTheme.colorScheme.primary),
                    onClick = {
                        onDismiss()
                    }
                ) {
                    Text(
                        style = MaterialTheme.typography.titleMedium,
                        color = AppColors.White,
                        text = dismissText
                    )
                }

                TextButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Transparent),
                    onClick = {
                        onDismiss()
                        onConfirm()
                    }
                ) {
                    Text(
                        style = MaterialTheme.typography.bodyLarge,
                        color = AppColors.Gray04,
                        text = confirmText
                    )
                }
            }
        }
    }
}