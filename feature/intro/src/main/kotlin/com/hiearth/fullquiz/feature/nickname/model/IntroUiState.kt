package com.hiearth.fullquiz.feature.nickname.model

import com.hiearth.fullquiz.core.model.User

sealed class IntroUiState () {
    data object Init : IntroUiState()
    data object Loading : IntroUiState()
    data class Success(val user: User) : IntroUiState()
    data class Failure(val throwable: Throwable) : IntroUiState()
}
