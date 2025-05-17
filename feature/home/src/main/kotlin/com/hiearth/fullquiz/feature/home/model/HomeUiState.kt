package com.hiearth.fullquiz.feature.home.model

import com.hiearth.fullquiz.core.model.User

sealed class HomeUiState() {
    data object Init : HomeUiState()
    data object Loading : HomeUiState()
    data class Success(val user: User) : HomeUiState()
    data class Failure(val throwable: Throwable) : HomeUiState()
}
