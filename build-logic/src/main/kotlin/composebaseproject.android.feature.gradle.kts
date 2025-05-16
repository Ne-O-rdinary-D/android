import com.example.composebaseproject.libs

plugins {
    id("composebaseproject.android.library")
    id("composebaseproject.android.compose")
}

android {
    packaging {
        resources.excludes.add("META-INF/**")
    }
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {
    implementation(project(":core:designsystem"))
    implementation(project(":core:navigation"))
    implementation(project(":core:model"))
    implementation(project(":core:data"))

    val libs = project.extensions.libs

    implementation(libs.findLibrary("hilt.navigation.compose").get())
    implementation(libs.findLibrary("androidx.compose.navigation").get())
    androidTestImplementation(libs.findLibrary("androidx.compose.navigation.test").get())
}