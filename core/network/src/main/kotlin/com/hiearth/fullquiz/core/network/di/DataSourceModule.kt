package com.hiearth.fullquiz.core.network.di

import com.hiearth.fullquiz.core.network.datasource.MyDataSource
import com.hiearth.fullquiz.core.network.datasource.QuizDataSource
import com.hiearth.fullquiz.core.network.datasource.QuizMyDataSource
import com.hiearth.fullquiz.core.network.datasource.RankDataSource
import com.hiearth.fullquiz.core.network.datasource.UserDataSource
import com.hiearth.fullquiz.core.network.retrofit.FakeRankDataSource
import com.hiearth.fullquiz.core.network.retrofit.RetrofitMyDataSource
import com.hiearth.fullquiz.core.network.retrofit.RetrofitQuizDataSource
import com.hiearth.fullquiz.core.network.retrofit.RetrofitQuizMyDataSource
import com.hiearth.fullquiz.core.network.retrofit.RetrofitRankDataSource
import com.hiearth.fullquiz.core.network.retrofit.RetrofitUserDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier


// 단순히 구현체 - interface 연결이면 Binds 사용
@Module
@InstallIn(SingletonComponent::class)
internal abstract class DataSourceModule {

    @Binds
    abstract fun bindUserDataSource(
        retrofitUserDataSource: RetrofitUserDataSource
    ): UserDataSource

    @Binds
    @RealDataSource
    abstract fun bindRankDataSource(
        retrofitRankDataSource: RetrofitRankDataSource
    ): RankDataSource

    @Binds
    @FakeDataSource
    abstract fun bindFakeRankDataSource(
        fakeRankDataSource: FakeRankDataSource
    ): RankDataSource

    @Binds
    @RealDataSource
    abstract fun bindMyDataSource(
        retrofitMyDataSource: RetrofitMyDataSource
    ): MyDataSource

    @Binds
    abstract fun bindQuizDataSource(
        quizDataSource: RetrofitQuizDataSource
    ): QuizDataSource


    @Binds
    abstract fun bindQuizMyDataSource(
        retrofitQuizMyDataSource: RetrofitQuizMyDataSource
    ): QuizMyDataSource
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class RealDataSource

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class FakeDataSource

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class FakeQuiz