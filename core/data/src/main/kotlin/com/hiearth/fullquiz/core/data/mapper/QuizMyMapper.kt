package com.hiearth.fullquiz.core.data.mapper

import com.hiearth.fullquiz.core.model.Category
import com.hiearth.fullquiz.core.model.ChapterStatusType
import com.hiearth.fullquiz.core.model.Interests
import com.hiearth.fullquiz.core.model.QuizMyResponse

internal fun QuizMyResponse.toCategory(): List<Category>{
    this.data.let{
        val data = it.map{
            Category(
                bigCategory = when(it.categoryId){
                    1-> Interests.RECYCLE
                    2-> Interests.CLIMATE
                    3-> Interests.ENDANGERED
                    else -> Interests.RECYCLE
                },
                list = it.childrenCategoriesList.map {
                    Category.DetailCategory(
                        categoryId = it.category_id,
                        categoryName = it.category_name,
                        status = when(it.status){
                            "ENDED" -> ChapterStatusType.COMPLETE
                            "INACTIVATED" -> ChapterStatusType.NOT_STARTED
                            "ACTIVATED" -> ChapterStatusType.IN_PROGRESS
                            else -> ChapterStatusType.NOT_STARTED
                        }
                    )
                }
            )
        }
        return data
    }
}