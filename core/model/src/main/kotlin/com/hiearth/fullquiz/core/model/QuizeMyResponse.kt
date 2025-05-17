package com.hiearth.fullquiz.core.model

import kotlinx.serialization.Serializable

@Serializable
data class QuizMyResponse(
    val status: Int,
    val message: String? = null,
    val data: List<CategoryData>,
    val errorCode: String? = null
)

@Serializable
data class CategoryData(
    val categoryId: Int,
    val parentTitle: String,
    val childrenCategoriesList: List<ChildCategory>
)

@Serializable
data class ChildCategory(
    val category_id: Int,
    val category_name: String,
    val status: String
)
