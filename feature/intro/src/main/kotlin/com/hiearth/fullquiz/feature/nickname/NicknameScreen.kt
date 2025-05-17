package com.hiearth.fullquiz.feature.nickname

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.hiearth.fullquiz.feature.nickname.component.NextButton
import com.hiearth.fullquiz.feature.nickname.model.CheckType
import com.hiearth.fullquiz.feature.nickname.model.IntroUiState

@Composable
internal fun IntroRoute(
    padding: PaddingValues,
    viewModel: IntroViewModel = hiltViewModel()
) {
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()

    var nickname by remember { mutableStateOf("") }
    var checkRedundancy by remember { mutableStateOf(CheckType.DUPLICATE_CHECK) }

    IntroScreen(
        padding = padding,
        uiState = uiState.value,
        nickname = nickname,
        onNicknameChange = { nickname = it },
        checkRedundancy = checkRedundancy
    )
}

@Composable
private fun IntroScreen(
    padding: PaddingValues,
    uiState: IntroUiState,
    nickname: String,
    onNicknameChange: (String) -> Unit,
    checkRedundancy: CheckType
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(horizontal = 20.dp)
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "닉네임 설정"
        )

        Text(
            text = "지구를 지켜줄\n닉네임을 설정해주세요"
        )

        Row {
            EditTextBox(
                value = nickname,
                onValueChange = onNicknameChange,
                statusColor = Color(0xFF04BA70)
            )

            Text(
                text = checkRedundancy.type
            )
        }

        
        NextButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            text = "다음"
        ) { 
            
        }
    }
}


@Composable
fun EditTextBox(
    value: String,
    onValueChange: (String) -> Unit,
    statusColor: Color = Color.Black,
    placeholder: String = "입력해주세요!",
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 4.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            // 입력 필드
            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                textStyle = TextStyle(fontSize = 16.sp, color = Color.Black),
                singleLine = true,
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp),
                decorationBox = { innerTextField ->
                    if (value.isEmpty()) {
                        Text(
                            text = placeholder,
                            style = TextStyle(color = Color.Gray, fontSize = 16.sp)
                        )
                    }
                    innerTextField()
                }
            )
        }

        // 밑줄
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp),
            color = Color.DarkGray
        )
    }
}


@Composable
@Preview
private fun NicknameScreenPrev() {

}