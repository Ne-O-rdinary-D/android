package com.hiearth.fullquiz

import org.gradle.api.Project

fun Project.setNamespace(name: String) {
    androidExtension.apply {
        namespace = "com.hiearth.fullquiz.$name"
    }
}