import com.hiearth.fullquiz.setNamespace

plugins {
    alias(libs.plugins.fullquiz.android.feature)
}

setNamespace("feature.main")

dependencies {
    implementation(projects.feature.home)
    implementation(projects.feature.nickname)
    implementation(libs.kotlinx.immutable)
}