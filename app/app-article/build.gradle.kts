dependencies {
    implementation(project(":base:base-starter"))
    implementation(project(":domain:domain-article"))

    implementation(Libs.springBootWeb)

    testImplementation(Libs.springBootTest)
    testImplementation(Libs.springMockk)
}
