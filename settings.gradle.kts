pluginManagement {
    repositories {
        google()
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

rootProject.name = "NinhoHub"
include(":app")

// Módulos Core
include(":core:ui")
include(":core:database")
include(":core:navigation")

// Módulos Feature
include(":feature:home:presentation")
include(":feature:grocery:domain")
include(":feature:grocery:data")
include(":feature:grocery:presentation")
