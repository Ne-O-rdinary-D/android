package com.hiearth.fullquiz.core.network.di

import com.hiearth.fullquiz.core.network.MyApi
import com.hiearth.fullquiz.core.network.QuizApi
import com.hiearth.fullquiz.core.network.RankApi
import com.hiearth.fullquiz.core.network.UserApi
import com.hiearth.fullquiz.core.network.datasource.RankDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object NetworkModule {

    @Singleton
    @Provides
    fun providesNetworkJson(): Json = Json {
        // Json을 보기 좋게 들여쓰기 형태로 출력 (디버깅)
        prettyPrint = true
        // Json에 정의되지 않은 필드가 있어도 무시하고 파싱 (버전 호환성 향상)
        ignoreUnknownKeys = true
        // 기본값도 JSON에 포함하여 직렬화(디버깅, 전체 상태 저장용)
        encodeDefaults = true
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .apply {
                if (com.hiearth.fullquiz.core.network.BuildConfig.DEBUG) {
                    addNetworkInterceptor(
                        HttpLoggingInterceptor().apply {
                            level = HttpLoggingInterceptor.Level.BODY
                        }
                    )
                }
            }
            .build()

    @Provides
    @Singleton
    fun provideRetrofit(json: Json, okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(com.hiearth.fullquiz.core.network.BuildConfig.BASE_URL)
            .addConverterFactory(json.asConverterFactory(TYPE_JSON.toMediaType()))
            .build()

    private const val TYPE_JSON = "application/json"

    @Provides
    fun provideRetrofitApi(retrofit: Retrofit): UserApi =
        retrofit.create(UserApi::class.java)

    @Provides
    fun provideRankApi(retrofit: Retrofit): RankApi =
        retrofit.create(RankApi::class.java)

    @Provides
    fun provideMyApi(retrofit: Retrofit): MyApi =
        retrofit.create(MyApi::class.java)

    @Provides
    fun provideQuizApi(retrofit: Retrofit): QuizApi =
        retrofit.create(QuizApi::class.java)
}