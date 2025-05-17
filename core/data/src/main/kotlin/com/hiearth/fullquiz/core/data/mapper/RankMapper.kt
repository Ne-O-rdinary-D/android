package com.hiearth.fullquiz.core.data.mapper

import com.hiearth.fullquiz.core.model.RankData
import com.hiearth.fullquiz.core.network.model.response.RankResponse


internal fun RankResponse.toRankData(): Pair<RankData, List<RankData>> {
    this.data.let {
        val myRankData = it.myInfo.run {
            RankData(
                nickname = nickname,
                correctProblem = answerCnt,
                incorrectProblem = wrongCnt,
                rank = nowRank
            )
        }

        val rankList = it.userRankingList.map{
            RankData(
                nickname = it.nickname,
                correctProblem = it.answerCnt,
                incorrectProblem = it.wrongCnt,
                rank = it.nowRank
            )
        }

        return (myRankData to rankList)
    }
}