import com.example.composebaseproject.setNamespace

plugins {
    alias(libs.plugins.composebaseproject.android.library)
    alias(libs.plugins.composebaseproject.android.compose)
    alias(libs.plugins.kotlin.serialization)
}

setNamespace("core.navigation")

dependencies {
    implementation(libs.kotlinx.serialization.json)
}