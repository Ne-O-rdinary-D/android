import com.hiearth.fullquiz.setNamespace

plugins {
    alias(libs.plugins.fullquiz.android.feature)
}


setNamespace("feature.rank")
dependencies {
    implementation(libs.androidx.core)
}
