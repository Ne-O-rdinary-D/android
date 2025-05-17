package com.hiearth.fullquiz.core.data

import com.hiearth.fullquiz.core.model.RankData

interface RankRepository {
    suspend fun getRankData(nickname: String): Result<Pair<RankData, List<RankData>>>
}