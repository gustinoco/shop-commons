pluginManagement {
    repositories {
        google()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)

        google()
        mavenCentral()
    }
}

include(":app")
include(":shopcommons")