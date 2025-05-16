package com.example.composebaseproject.feature.home.model

import com.example.composebaseproject.core.model.User

sealed class HomeUiState() {
    data object Init : HomeUiState()
    data object Loading : HomeUiState()
    data class Success(val user: User) : HomeUiState()
    data class Failure(val throwable: Throwable) : HomeUiState()
}
