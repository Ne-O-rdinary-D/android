package com.hiearth.fullquiz.feature.rank.model

sealed class RankUiState() {
    data object Init : RankUiState()
    data object Loading : RankUiState()
    data class Success(val nickname: String, val myRankData: MyRankData, val rankList: List<RankData>) : RankUiState()
    data class Failure(val throwable: Throwable) : RankUiState()

    companion object {
        fun test() = Success(
            myRankData = MyRankData(1, 1, 1), rankList = listOf(
                RankData("1", 1, 1),
                RankData("1", 1, 1),
                RankData("test", 1, 1),
                RankData("1", 1, 1),
                RankData("1", 1, 1),
                RankData("1", 1, 1),
                RankData("1", 1, 1),
                RankData("1", 1, 1)
            ),
            nickname = "test"
        )
    }
}

data class MyRankData(
    val myRank: Int,
    val correctProblem: Int,
    val incorrectProblem: Int
)

data class RankData(
    val nickname: String,
    val rank: Int,
    val correctProblem: Int
)