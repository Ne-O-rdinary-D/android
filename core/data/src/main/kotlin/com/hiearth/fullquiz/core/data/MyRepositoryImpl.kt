package com.hiearth.fullquiz.core.data

import com.hiearth.fullquiz.core.network.datasource.MyDataSource
import com.hiearth.fullquiz.core.network.di.RealUserDataSource
import javax.inject.Inject

class MyRepositoryImpl @Inject constructor(
    @RealUserDataSource val myDataSource: MyDataSource
): MyRepository {
}