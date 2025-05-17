package com.hiearth.fullquiz

import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.compose.compiler.gradle.ComposeCompilerGradlePluginExtension
import org.jetbrains.kotlin.compose.compiler.gradle.ComposeFeatureFlag

internal fun Project.configureComposeAndroid() {
    with(plugins) {
        apply("org.jetbrains.kotlin.plugin.compose")
    }

    val libs = extensions.libs
    val isRelease = project.gradle.startParameter.taskNames.any {
        it.contains("Release", ignoreCase = true)
    }

    dependencies {
        val bom = libs.findLibrary("androidx-compose-bom").get()

        add("implementation", platform(bom))
        add("androidTestImplementation", platform(bom))

        add("implementation", libs.findLibrary("androidx.compose.material3").get())
        add("implementation", libs.findLibrary("androidx.compose.ui").get())
        add("implementation", libs.findLibrary("androidx.compose.ui.tooling.preview").get())
        add("androidTestImplementation", libs.findLibrary("androidx.test.ext").get())
        add("androidTestImplementation", libs.findLibrary("androidx.test.espresso.core").get())
        add("androidTestImplementation", libs.findLibrary("androidx.compose.ui.test").get())
        add("debugImplementation", libs.findLibrary("androidx.compose.ui.tooling").get())
        add("debugImplementation", libs.findLibrary("androidx.compose.ui.testManifest").get())
    }

    extensions.getByType<ComposeCompilerGradlePluginExtension>().apply {
        featureFlags.add(ComposeFeatureFlag.StrongSkipping)
        includeSourceInformation.set(!isRelease)
    }
}