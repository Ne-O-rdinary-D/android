import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties
import com.hiearth.fullquiz.setNamespace

plugins {
    alias(libs.plugins.fullquiz.android.library)
    alias(libs.plugins.kotlin.serialization)
}

setNamespace("core.network")

android {
    buildTypes {
        debug {
            buildConfigField("String", "BASE_URL", getProperty("baseDevUrl"))
        }
        release {
            buildConfigField("String", "BASE_URL", getProperty("prodDevUrl"))
        }
    }
}

fun getProperty(key: String): String {
    return gradleLocalProperties(rootDir, providers).getProperty(key)
}

dependencies {
    implementation(projects.core.model)

    implementation(libs.okhttp.logging)
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.kotlin.serialization)
    implementation(libs.kotlinx.serialization.json)
}