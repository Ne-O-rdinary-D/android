import com.hiearth.fullquiz.setNamespace

plugins {
    alias(libs.plugins.fullquiz.android.feature)
}


setNamespace("feature.intro")
dependencies {
    implementation(project(":core:local"))
}
