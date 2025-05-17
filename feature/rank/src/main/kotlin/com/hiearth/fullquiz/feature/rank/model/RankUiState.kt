package com.hiearth.fullquiz.feature.rank.model

import com.hiearth.fullquiz.core.model.RankData

sealed class RankUiState() {
    data object Init : RankUiState()
    data object Loading : RankUiState()
    data class Success(val nickname: String, val myRankData: RankData, val rankList: List<RankData>) : RankUiState()
    data class Failure(val throwable: Throwable) : RankUiState()

    companion object {
        fun test() = Success(
            myRankData = RankData("test",1, 1, 1), rankList = listOf(
                RankData("1", 1, 1, -1),
                RankData("1", 1, 1, -1),
                RankData("test", 1, 1, -1),
                RankData("1", 1, 1, -1),
                RankData("1", 1, 1, -1),
                RankData("1", 1, 1, -1),
                RankData("1", 1, 1, -1),
                RankData("1", 1, 1, -1),
                RankData("1", 1, 1, -1),
            ),
            nickname = "test"
        )
    }
}

