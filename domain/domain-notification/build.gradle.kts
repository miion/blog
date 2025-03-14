dependencies {
    implementation(project(":base:base-starter-sse"))
    implementation(project(":external:external-kma-api"))
    implementation(Libs.springBootWeb)

    testImplementation(Libs.kotestSpring)
    testImplementation(Libs.springBootTest)
}