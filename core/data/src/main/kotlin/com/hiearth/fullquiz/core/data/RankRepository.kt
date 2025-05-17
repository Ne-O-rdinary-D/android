package com.hiearth.fullquiz.core.data

import com.hiearth.fullquiz.core.model.RankData
import com.hiearth.fullquiz.core.network.model.response.rank.MyRankResponse
import com.hiearth.fullquiz.core.network.model.response.rank.RankDataResponse

interface RankRepository {
    suspend fun getLoadPage(): Result<Pair<RankData, List<RankData>>>

    suspend fun getMyData(): Result<RankData>

    suspend fun getRankList(): Result<List<RankData>>
}