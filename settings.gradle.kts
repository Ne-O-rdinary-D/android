pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        gradlePluginPortal()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "FullQuiz"
include(":app")

include(":feature:main")
include(":feature:home")
include(":feature:intro")
include(":feature:quiz")
include(":feature:rank")
include(":feature:my")

include(":core:local")
include(":core:network")
include(":core:model")
include(":core:data")
include(":core:designsystem")
include(":core:navigation")
