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
        gradlePluginPortal()
    }
}
rootProject.name = "BCP Design Patterns"

include(":app")

//Core
include(":core:bcpCore")
include(":core:coreUi")

// Feature
include(":features:featureHome")
include("features:featureBatteryInfo")
include("features:featureSystemInfo")

// Data
include(":data:localDatasource")
