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

    const val micrometerPrometheus = "io.micrometer:micrometer-registry-prometheus"
    const val micrometerCore = "io.micrometer:micrometer-core"

    object Bom {
        val definitions = listOf(
            "org.springframework.boot:spring-boot-dependencies:${Versions.Bom.springBoot}",
            "org.mion.customized:customized-bom:${Versions.Bom.base}"
        )
    }
}


object Project {

}

object Plugins {
    const val springBoot = "org.springframework.boot"
    const val springDependencyManagement = "io.spring.dependency-management"
}