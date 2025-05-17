package com.hiearth.fullquiz.core.data.di

import com.hiearth.fullquiz.core.data.MyRepository
import com.hiearth.fullquiz.core.data.MyRepositoryImpl
import com.hiearth.fullquiz.core.data.RankRepository
import com.hiearth.fullquiz.core.data.RankRepositoryImpl
import com.hiearth.fullquiz.core.data.UserRepository
import com.hiearth.fullquiz.core.data.UserRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class RepositoryModule {
    @Binds
    abstract fun bindUserRepository(
        userRepository: UserRepositoryImpl
    ): UserRepository


    @Binds
    abstract fun bindRankRepository(
        rankRepositoryImpl: RankRepositoryImpl
    ): RankRepository

    @Binds
    abstract fun bindMyRepository(
        myRepositoryImpl: MyRepositoryImpl
    ): MyRepository
}
