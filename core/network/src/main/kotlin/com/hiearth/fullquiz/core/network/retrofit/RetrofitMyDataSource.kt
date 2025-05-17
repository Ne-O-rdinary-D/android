package com.hiearth.fullquiz.core.network.retrofit

import com.hiearth.fullquiz.core.network.MyApi
import com.hiearth.fullquiz.core.network.datasource.MyDataSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RetrofitMyDataSource @Inject constructor(
    myApi: MyApi
): MyDataSource {
}