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
include(":feature-home:home-presentation")
include(":feature-grocery:grocery-domain")
include(":feature-grocery:grocery-data")
include(":feature-grocery:grocery-presentation")
