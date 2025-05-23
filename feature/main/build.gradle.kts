import com.hiearth.fullquiz.setNamespace

plugins {
    alias(libs.plugins.fullquiz.android.feature)
}

setNamespace("feature.main")

dependencies {
    implementation(projects.feature.home)
    implementation(projects.feature.intro)
    implementation(projects.feature.quiz)

    implementation(libs.kotlinx.immutable)
    implementation(projects.feature.rank)
    implementation(projects.feature.my)
}