plugins {
    alias(libs.plugins.fullquiz.android.application)
    alias(libs.plugins.fullquiz.android.compose)
}

android {
    namespace = "com.hiearth.fullquiz"

    defaultConfig {
        applicationId = "com.hiearth.fullquiz"
        versionCode = 1
        versionName = "1.0"
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    buildTypes {
        release {
            signingConfig = signingConfigs.getByName("debug")

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation(projects.feature.main)
}