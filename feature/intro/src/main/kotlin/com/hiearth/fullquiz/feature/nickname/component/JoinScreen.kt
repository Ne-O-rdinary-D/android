package com.hiearth.fullquiz.feature.nickname.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hiearth.fullquiz.core.designsystem.theme.MainGreen
import com.hiearth.fullquiz.core.designsystem.theme.Typography
import com.hiearth.fullquiz.core.model.Interests
import com.hiearth.fullquiz.core.model.User
import com.hiearth.fullquiz.feature.nickname.EditTextBox
import com.hiearth.fullquiz.feature.nickname.model.CheckType
import com.hiearth.fullquiz.feature.nickname.model.IntroUiState

@Composable
internal fun JoinScreen(
    uiState: IntroUiState.Join,
    checkRedundancy: CheckType,
    onNicknameChange: (String) -> Unit,
    onValidCheck: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
    ) {
        Spacer(
            modifier = Modifier.height(80.dp)
        )

        Text(
            text = "지구를 지켜줄",
            color = MainGreen,
            style = MaterialTheme.typography.displayLarge
        )
        Spacer(
            modifier = Modifier.height(8.dp)
        )
        Text(
            text = "닉네임을 설정해주세요!",
            style = MaterialTheme.typography.displayLarge
        )


        Spacer(
            modifier = Modifier.height(160.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            EditTextBox(
                value = uiState.user.name,
                onValueChange = { onNicknameChange(it) },
                modifier = Modifier.weight(1f)
            )

            Spacer(modifier = Modifier.width(12.dp))

            Text(
                text = checkRedundancy.type,
                color = Color.Black,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.wrapContentWidth().clickable{
                        onValidCheck()
                }
            )
        }


        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp)
                .height(1.dp),
            color = Color.DarkGray
        )
    }
}


@Preview
@Composable
fun JoinScreenPrev() {
    JoinScreen(
        uiState = IntroUiState.Join(
            user = User(
                id = 0,
                name = "haha"
            ),
            interests = Interests.CLIMATE,
            validCheckType = CheckType.DUPLICATE_CHECK
        ),
        checkRedundancy = CheckType.DUPLICATE_CHECK,
        onNicknameChange = {},
        onValidCheck = {}
    )
}
