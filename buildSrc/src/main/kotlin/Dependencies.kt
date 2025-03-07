object Versions {

    object Bom {
        const val base = "1.0.0"
        const val springBoot = "3.4.2"
    }
}

object Libs {
    const val springWeb = "org.springframework:spring-web"
    const val springWebMvc = "org.springframework:spring-webmvc"

    const val springBoot = "org.springframework.boot:spring-boot"
    const val springBootWeb = "org.springframework.boot:spring-boot-starter-web"
    const val springBootValidation = "org.springframework.boot:spring-boot-starter-validation"
    const val springBootWebSocket = "org.springframework.boot:spring-boot-starter-websocket"

    const val springBootMongo = "org.springframework.boot:spring-boot-starter-data-mongodb"

    const val micrometerPrometheus = "io.micrometer:micrometer-registry-prometheus"
    const val micrometerCore = "io.micrometer:micrometer-core"

    const val slf4j = "org.slf4j:slf4j-api"
    const val kotlinJackson = "com.fasterxml.jackson.module:jackson-module-kotlin"
    const val kotlinReflect = "org.jetbrains.kotlin:kotlin-reflect"

    const val springBootTest = "org.springframework.boot:spring-boot-starter-test"
    const val kotestJunit = "io.kotest:kotest-runner-junit5"
    const val kotestAssertions = "io.kotest:kotest-assertions-core"
    const val mockk = "io.mockk:mockk"
    const val springMockk = "com.ninja-squad:springmockk"

    object Bom {
        val definitions = listOf(
            "org.springframework.boot:spring-boot-dependencies:${Versions.Bom.springBoot}",
            "org.mion.customized:customized-bom:${Versions.Bom.base}"
        )
    }
}


object Projects {
    const val base = ":base:base-starter"
    const val test = ":base:base-test"

    object Base {
        const val metrics = ":base:base-starter-metrics"
        const val mongodb = ":base:base-starter-mongodb"
        const val sse = ":base:base-starter-sse"
        const val web = ":base:base-starter-web"
    }

    object Common {
        const val metrics = ":common:common-metrics"
        const val utils = ":common:common-utils"
    }
}

object Plugins {
    const val springBoot = "org.springframework.boot"
    const val springDependencyManagement = "io.spring.dependency-management"
}