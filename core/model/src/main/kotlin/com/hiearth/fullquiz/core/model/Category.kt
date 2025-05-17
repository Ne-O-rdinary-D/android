package com.hiearth.fullquiz.core.model



data class Category(
    val bigCategory: Interests,
    val list: List<DetailCategory>
) {
    data class DetailCategory(
        val categoryId: Int,
        val categoryName: String,
        val status: ChapterStatusType
    )
}