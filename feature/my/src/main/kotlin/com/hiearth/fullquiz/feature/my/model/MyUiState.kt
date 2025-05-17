package com.hiearth.fullquiz.feature.my.model

import com.hiearth.fullquiz.core.model.Category

sealed class MyUiState() {
    data object Init : MyUiState()
    data object Loading : MyUiState()
    data class Success(
        val nickname: String,
        val chapterStatusList: List<Category>) : MyUiState()
    data class Failure(val throwable: Throwable) : MyUiState()
}
