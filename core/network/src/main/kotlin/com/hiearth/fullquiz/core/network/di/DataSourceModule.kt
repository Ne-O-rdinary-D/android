package com.hiearth.fullquiz.core.network.di

import com.hiearth.fullquiz.core.network.datasource.QuizDataSource
import com.hiearth.fullquiz.core.network.datasource.UserDataSource
import com.hiearth.fullquiz.core.network.retrofit.FakeQuizDataSource
import com.hiearth.fullquiz.core.network.retrofit.FakeUserDataSource
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
    @RealUserDataSource
    abstract fun bindUserDataSource(
        retrofitUserDataSource: RetrofitUserDataSource
    ): UserDataSource

    @Binds
    @FakeDataSource
    abstract fun bindFakeUserDataSource(
        fakeUserDataSource: FakeUserDataSource
    ): UserDataSource

    @Binds
    @FakeQuiz
    abstract fun bindFakeQuizDataSource(
        fakeQuizDataSource: FakeQuizDataSource
    ): QuizDataSource

}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class RealUserDataSource

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class FakeDataSource

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class FakeQuiz