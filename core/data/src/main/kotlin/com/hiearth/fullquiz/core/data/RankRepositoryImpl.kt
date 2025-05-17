package com.hiearth.fullquiz.core.data

import com.hiearth.fullquiz.core.data.mapper.toRankData
import com.hiearth.fullquiz.core.data.mapper.toResult
import com.hiearth.fullquiz.core.model.RankData
import com.hiearth.fullquiz.core.network.datasource.RankDataSource
import com.hiearth.fullquiz.core.network.di.FakeDataSource
import com.hiearth.fullquiz.core.network.di.RealDataSource
import javax.inject.Inject


internal class RankRepositoryImpl @Inject constructor(
    @RealDataSource val rankDataSource: RankDataSource
) : RankRepository {
    override suspend fun getRankData(nickname: String): Result<Pair<RankData, List<RankData>>> {
        val response = rankDataSource.getRankData(nickname)
        val result = response.toResult(transform = { it.toRankData() })

        return result
    }
}