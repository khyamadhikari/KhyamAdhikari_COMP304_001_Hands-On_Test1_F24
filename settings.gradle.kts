// Project level build.gradle.kts (settings.gradle.kts)
pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "KhyamAdhikari_COMP304_001_HandsOn_Test1_F24"
include(":app")
