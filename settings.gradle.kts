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
project(":feature:home:presentation").projectDir = file("feature/home/home-presentation")

include(":feature:grocery:domain")
project(":feature:grocery:domain").projectDir = file("feature/grocery/grocery-domain")

include(":feature:grocery:data")
project(":feature:grocery:data").projectDir = file("feature/grocery/grocery-data")

include(":feature:grocery:presentation")
project(":feature:grocery:presentation").projectDir = file("feature/grocery/grocery-presentation")
