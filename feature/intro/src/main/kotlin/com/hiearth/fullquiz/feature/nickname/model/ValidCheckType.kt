package com.hiearth.fullquiz.feature.nickname.model

enum class ValidCheckType(val type: String) {
    DUPLICATE_CHECK("중복확인"),
    AVAILABLE("사용가능"),
    UNAVAILABLE("사용불가")
}
