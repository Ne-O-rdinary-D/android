package com.example.composebaseproject

import org.gradle.api.Project

fun Project.setNamespace(name: String) {
    androidExtension.apply {
        namespace = "com.example.composebaseproject.$name"
    }
}