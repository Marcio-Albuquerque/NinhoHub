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

// Módulos Feature Home
include(":feature:home:api")
include(":feature:home:impl")

// Módulos Feature Grocery
include(":feature:grocery:api")
include(":feature:grocery:impl")
include(":feature:grocery:domain")
include(":feature:grocery:data")
