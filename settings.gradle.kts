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
include(":core-ui")
include(":core-navigation")
include(":feature-home:home-presentation")
include(":feature-grocery:grocery-presentation")
