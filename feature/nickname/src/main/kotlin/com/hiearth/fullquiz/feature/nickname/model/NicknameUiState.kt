package com.hiearth.fullquiz.feature.nickname.model

import com.hiearth.fullquiz.core.model.User

sealed class NicknameUiState () {
    data object Init : NicknameUiState()
    data object Loading : NicknameUiState()
    data class Success(val user: User) : NicknameUiState()
    data class Failure(val throwable: Throwable) : NicknameUiState()
}
