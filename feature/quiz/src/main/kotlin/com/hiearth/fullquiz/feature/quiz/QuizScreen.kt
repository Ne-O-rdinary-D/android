package com.hiearth.fullquiz.feature.quiz

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.hiearth.fullquiz.core.designsystem.theme.AppColors
import com.hiearth.fullquiz.core.designsystem.theme.MainGreen
import com.hiearth.fullquiz.core.designsystem.theme.Typography
import com.hiearth.fullquiz.core.model.Answer
import com.hiearth.fullquiz.core.model.Interests
import com.hiearth.fullquiz.core.model.Quiz
import com.hiearth.fullquiz.core.model.QuizType
import com.hiearth.fullquiz.feature.quiz.component.ABButtons
import com.hiearth.fullquiz.feature.quiz.component.AnswerColumn
import com.hiearth.fullquiz.feature.quiz.component.OXButtons
import com.hiearth.fullquiz.feature.quiz.component.PrevNextButtons
import com.hiearth.fullquiz.feature.quiz.component.QuizHeader
import com.hiearth.fullquiz.feature.quiz.component.QuizIndicator
import com.hiearth.fullquiz.feature.quiz.model.QuizUiState

@Composable
internal fun QuizRoute(
    padding: PaddingValues,
    viewModel: QuizViewModel = hiltViewModel(),
    navigateHome: () -> Unit,
    navigateRanking: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    var currentStep by remember { mutableStateOf(0) }

    when (uiState) {
        is QuizUiState.Loading -> LoadingScreen()
        is QuizUiState.Success -> {
            QuizScreen(
                padding = padding,
                quizList = (uiState as QuizUiState.Success).quizList,
                interests = (uiState as QuizUiState.Success).interests,
                currentStep = currentStep,
                changeCurrentStep = { currentStep = it },
                selectAnswer = viewModel::selectAnswer,
                navigateHome = navigateHome,
                navigateRanking = navigateRanking
            )
        }

        is QuizUiState.Failure -> {}
    }
}

@Composable
private fun QuizScreen(
    padding: PaddingValues,
    quizList: List<Quiz>,
    interests: Interests,
    currentStep: Int = 3,
    changeCurrentStep: (Int) -> Unit = {},
    selectAnswer: (Int, Answer) -> Unit = { _, _ -> },
    navigateHome: () -> Unit = {},
    navigateRanking: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .background(AppColors.White)
            .padding(padding)
            .padding(24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        QuizHeader(
            interests = interests,
            navigateRanking = navigateRanking
        )
        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Spacer(modifier = Modifier.height(8.dp))
            QuizIndicator(currentStep = currentStep)
            Spacer(modifier = Modifier.height(8.dp))
            Column(
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                Text(
                    text = "Q.",
                    style = MaterialTheme.typography.titleLarge,
                    color = AppColors.Black
                )
                Text(
                    text = quizList[currentStep].content,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontSize = 20.sp
                    ),
                    color = AppColors.Black,
                    minLines = 3
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            if (quizList[currentStep].quizType == QuizType.OX) {
                OXButtons(
                    isAnswered = quizList[currentStep].userAnswer != null,
                    userAnswer = quizList[currentStep].userAnswer,
                    onSelect = { selectAnswer(quizList[currentStep].quizId, it) }
                )
            } else {
                ABButtons(
                    isAnswered = quizList[currentStep].userAnswer != null,
                    userAnswer = quizList[currentStep].userAnswer,
                    firstOption = quizList[currentStep].firstOption,
                    secondOption = quizList[currentStep].secondOption,
                    onSelect = { selectAnswer(quizList[currentStep].quizId, it) }
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            if (quizList[currentStep].userAnswer != null) {
                AnswerColumn(
                    isCorrect = quizList[currentStep].userAnswer == quizList[currentStep].answer,
                    explanation = quizList[currentStep].explanation
                )
            }
        }
        PrevNextButtons(
            quizIndex = currentStep,
            onClickPrev = { if (currentStep > 0) changeCurrentStep(currentStep - 1) },
            onClickNext = { if (currentStep < quizList.size - 1) changeCurrentStep(currentStep + 1) },
            onClickComplete = {
                // TODO 완료 다이얼로그
            }
        )
    }
}

@Composable
private fun LoadingScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier.padding(end = 24.dp),
            painter = painterResource(id = R.drawable.ic_icon),
            contentDescription = "로고",
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "잠시만 기다려주세요",
            color = MainGreen,
            style = Typography.bodyMedium,
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "지구를 지켜가는 중이에요",
            color = MainGreen,
            style = Typography.bodyMedium,
        )
    }
}

