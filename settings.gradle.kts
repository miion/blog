dependencyResolutionManagement {
    @Suppress("UnstableApiUsage")
    repositories {
        mavenCentral()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

rootProject.name = "blog"
apply(from = "base/settings.gradle.kts")
apply(from = "common/settings.gradle.kts")
apply(from = "domain/settings.gradle.kts")
apply(from = "app/settings.gradle.kts")

include("docker:blog-api")
