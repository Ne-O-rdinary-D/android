import com.hiearth.fullquiz.setNamespace

plugins {
    alias(libs.plugins.fullquiz.android.library)
    alias(libs.plugins.kotlin.serialization)
}

setNamespace("core.data")

dependencies {
    implementation(projects.core.model)
    implementation(projects.core.network)
    implementation(projects.core.local)

    implementation(libs.kotlinx.serialization.json)
}