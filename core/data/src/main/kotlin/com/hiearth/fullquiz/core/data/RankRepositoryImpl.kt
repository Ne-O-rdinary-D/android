package com.hiearth.fullquiz.core.data

import com.hiearth.fullquiz.core.data.mapper.toRankData
import com.hiearth.fullquiz.core.data.mapper.toResult
import com.hiearth.fullquiz.core.model.RankData
import com.hiearth.fullquiz.core.network.datasource.RankDataSource
import com.hiearth.fullquiz.core.network.di.FakeDataSource
import javax.inject.Inject


internal class RankRepositoryImpl @Inject constructor(
    @FakeDataSource val rankDataSource: RankDataSource
) : RankRepository {
    override suspend fun getLoadPage(): Result<Pair<RankData, List<RankData>>> {
        val myRankResult = rankDataSource.getMyData().toResult(
            transform = { it.toRankData() }
        )
        val rankListResult = rankDataSource.getRankList().toResult(
            transform = { it.map { it.toRankData() } }
        )

        return if (myRankResult.isSuccess && rankListResult.isSuccess) {
            Result.success(
                myRankResult.getOrThrow() to rankListResult.getOrThrow()
            )
        } else {
            Result.failure(
                myRankResult.exceptionOrNull() ?: rankListResult.exceptionOrNull()
                ?: Throwable("Unknown error")
            )
        }
    }


    override suspend fun getMyData(): Result<RankData> {
        return rankDataSource.getMyData().toResult(
            transform = { it.toRankData() }
        )
    }

    override suspend fun getRankList(): Result<List<RankData>> {
        return rankDataSource.getRankList().toResult(
            transform = { it.map { it.toRankData() } }
        )
    }
}