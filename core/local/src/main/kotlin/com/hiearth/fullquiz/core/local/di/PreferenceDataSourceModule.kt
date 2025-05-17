package com.hiearth.fullquiz.core.local.di

import com.hiearth.fullquiz.core.local.datasource.PreferenceDataSource
import com.hiearth.fullquiz.core.local.datasource.PreferenceDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class PreferenceDataSourceModule {
    @Singleton
    @Binds
    abstract fun providePreferenceDataSource(
        preferenceDataSourceImpl: PreferenceDataSourceImpl
    ): PreferenceDataSource
}