package com.hiearth.fullquiz.feature.my.model

import com.hiearth.fullquiz.core.model.Interests

data class ChapterStatusData (
    val type: Interests,
    val chapterStatusList: List<ChapterStatusType>
)