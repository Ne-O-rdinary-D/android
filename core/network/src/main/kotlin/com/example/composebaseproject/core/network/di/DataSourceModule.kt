package com.example.composebaseproject.core.network.di

import com.example.composebaseproject.core.network.datasource.AuthDataSource
import com.example.composebaseproject.core.network.retrofit.RetrofitAuthDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

// 단순히 구현체 - interface 연결이면 Binds 사용
@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    abstract fun bindAuthDataSource(
        retrofitAuthDataSource: RetrofitAuthDataSource
    ): AuthDataSource

}