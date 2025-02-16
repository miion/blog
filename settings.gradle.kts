// The settings file is the entry point of every Gradle build.
// Its primary purpose is to define the subprojects.
// It is also used for some aspects of project-wide configuration, like managing plugins, dependencies, etc.
// https://docs.gradle.org/current/userguide/settings_file_basics.html

dependencyResolutionManagement {
    // Use Maven Central as the default repository (where Gradle will download dependencies) in all subprojects.
    @Suppress("UnstableApiUsage")
    repositories {
        mavenCentral()
    }
}

plugins {
    // Use the Foojay Toolchains plugin to automatically download JDKs required by subprojects.
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

// Include the `app` and `utils` subprojects in the build.
// If there are changes in only one of the projects, Gradle will rebuild only the one that has changed.
// Learn more about structuring projects with Gradle - https://docs.gradle.org/8.7/userguide/multi_project_builds.html

rootProject.name = "blog"
apply(from = "base/settings.gradle.kts")
apply(from = "common/settings.gradle.kts")
//include("docker")
include("docker:blog-api")
//findProject(":docker:blog-api")?.name = "blog-api"
//include("base")
//include("common")
//include("base:base-starter-metrics")
//findProject(":base:base-starter-metrics")?.name = "base-starter-metrics"
//include("common")
//include("common:common-utils")
//findProject(":common:common-utils")?.name = "common-utils"
//include("base")
//include("base:base-starter-metrics")
//findProject(":base:base-starter-metrics")?.name = "base-starter-metrics"
//include("common:common-metrics")
//findProject(":common:common-metrics")?.name = "common-metrics"
//include("base:base-starter-web")
//findProject(":base:base-starter-web")?.name = "base-starter-web"
//include("base:base-starter")
//findProject(":base:base-starter")?.name = "base-starter"
include(":app")
include(":chat")
