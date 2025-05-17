package com.hiearth.fullquiz.feature.my.model

import android.provider.ContactsContract.CommonDataKinds.Nickname
import com.hiearth.fullquiz.core.model.Interests
import com.hiearth.fullquiz.core.model.User

sealed class MyUiState() {
    data object Init : MyUiState()
    data object Loading : MyUiState()
    data class Success(
        val nickname: String,
        val chapterStatusList: List<ChapterStatusData>) : MyUiState()
    data class Failure(val throwable: Throwable) : MyUiState()

    companion object{
        fun test() = Success(
            nickname = "test",
            chapterStatusList = listOf(
                ChapterStatusData(
                    type = Interests.RECYCLE,
                    chapterStatusList = listOf(
                        ChapterStatusType.COMPLETE,
                        ChapterStatusType.COMPLETE,
                        ChapterStatusType.NOT_STARTED,
                        ChapterStatusType.IN_PROGRESS,
                        )
                ),
                ChapterStatusData(
                    type = Interests.CLIMATE,
                    chapterStatusList = listOf(
                        ChapterStatusType.COMPLETE,
                        ChapterStatusType.COMPLETE,
                        ChapterStatusType.NOT_STARTED,
                        ChapterStatusType.IN_PROGRESS,
                    )
                ),
                ChapterStatusData(
                    type = Interests.ENDANGERED,
                    chapterStatusList = listOf(
                        ChapterStatusType.COMPLETE,
                        ChapterStatusType.COMPLETE,
                        ChapterStatusType.NOT_STARTED,
                        ChapterStatusType.IN_PROGRESS,
                    )
                ),
            )
        )
    }
}
