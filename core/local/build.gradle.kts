import com.hiearth.fullquiz.setNamespace

plugins {
    alias(libs.plugins.fullquiz.android.library)
    alias(libs.plugins.kotlin.serialization)
}

setNamespace("core.local")
dependencies {
    implementation(project(":core:model"))
}
