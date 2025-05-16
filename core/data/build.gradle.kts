import com.example.composebaseproject.setNamespace

plugins {
    alias(libs.plugins.composebaseproject.android.library)
    alias(libs.plugins.kotlin.serialization)
}

setNamespace("core.data")

dependencies {
    implementation(projects.core.model)
    implementation(projects.core.network)

    implementation(libs.kotlinx.serialization.json)
}