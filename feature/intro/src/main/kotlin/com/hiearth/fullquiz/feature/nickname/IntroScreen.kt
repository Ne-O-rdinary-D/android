package com.hiearth.fullquiz.feature.nickname

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.hiearth.fullquiz.core.designsystem.theme.AppColors.Gray04
import com.hiearth.fullquiz.core.designsystem.theme.Typography
import com.hiearth.fullquiz.core.model.Interests
import com.hiearth.fullquiz.feature.nickname.component.JoinScreen
import com.hiearth.fullquiz.feature.nickname.component.NextButton
import com.hiearth.fullquiz.feature.nickname.component.SelectInterestScreen
import com.hiearth.fullquiz.feature.nickname.component.SplashScreen
import com.hiearth.fullquiz.feature.nickname.model.IntroUiState

@Composable
internal fun IntroRoute(
    padding: PaddingValues,
    viewModel: IntroViewModel = hiltViewModel(),
    navigateToHome: () -> Unit
) {
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()


    LaunchedEffect(Unit) {
        viewModel.getLoginState()
    }

    IntroScreen(
        padding = padding,
        uiState = uiState.value,
        onNicknameChange = { viewModel.onNicknameChanged(nickname = it) },
        onPageMove = {
                viewModel.onPageMove()
        },
        onSelectInterest = {
            viewModel.onInterestChanged(it)
        },
        onJoin = { navigateToHome() },
        onValidNickname = { }
    )
}

@Composable
private fun IntroScreen(
    padding: PaddingValues,
    uiState: IntroUiState,
    onNicknameChange: (String) -> Unit,
    onPageMove: () -> Unit,
    onSelectInterest: (Interests) -> Unit,
    onJoin: () -> Unit,
    onValidNickname: () -> Unit
) {
    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(padding)
    ) {
        when (uiState) {
            is IntroUiState.Failure -> {}
            IntroUiState.Init -> {
                SplashScreen()
            }

            is IntroUiState.Join -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = 20.dp)
                ) {
                    if (!(uiState.isNameSet)) {
                        JoinScreen(
                            uiState = uiState,
                            checkRedundancy = uiState.validCheckType,
                            onNicknameChange = { onNicknameChange(it) },
                            onValidCheck = onValidNickname
                        )
                    } else {
                        SelectInterestScreen(
                            selected = uiState.interests,
                            onSelect = onSelectInterest,
                            onBackClick = { onPageMove() }
                        )
                    }

                    NextButton(
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .fillMaxWidth()
                            .padding(horizontal = 24.dp),
                        text = if (uiState.isNameSet) "입장하기" else "다음",
                        onClick = {
                            if (!(uiState.isNameSet)) onPageMove()
                            else onJoin()
                        }
                    )
                }

            }

            IntroUiState.Logined -> {

            }
        }
    }
}


@Composable
fun EditTextBox(
    value: String,
    onValueChange: (String) -> Unit,
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
                            style = Typography.bodyMedium,
                            color = Gray04
                        )
                    }
                    innerTextField()
                }
            )
        }
    }
}


@Composable
@Preview
private fun NicknameScreenPrev() {

}