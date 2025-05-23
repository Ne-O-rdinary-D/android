package com.hiearth.fullquiz.core.data

import com.hiearth.fullquiz.core.network.datasource.MyDataSource
import com.hiearth.fullquiz.core.network.di.RealDataSource
import javax.inject.Inject

class MyRepositoryImpl @Inject constructor(
    @RealDataSource val myDataSource: MyDataSource
): MyRepository {
}