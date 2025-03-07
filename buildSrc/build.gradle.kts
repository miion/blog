plugins {
    `kotlin-dsl`
}

kotlin {
    jvmToolchain(17)
}


val springVersion: String by project
val springDependency: String by project

dependencies {
//    implementation(libs.kotlinGradlePlugin)
//    implementation(libs.springDepdencyManagementPlugin)
//    implementation(libs.springPlugin)
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:2.0.21")
    implementation("org.jetbrains.kotlin:kotlin-allopen:2.0.21")
    implementation("org.jetbrains.kotlin:kotlin-noarg:2.0.21")

    implementation("org.springframework.boot:spring-boot-gradle-plugin:${springVersion}")
    implementation("io.spring.gradle:dependency-management-plugin:${springDependency}")
}
