import com.example.composebaseproject.setNamespace

plugins {
    alias(libs.plugins.composebaseproject.android.feature)
}

setNamespace("feature.main")

dependencies {
    implementation(projects.feature.home)
    implementation(libs.kotlinx.immutable)
}