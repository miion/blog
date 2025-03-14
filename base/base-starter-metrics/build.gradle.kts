dependencies {
    implementation(project(":common:common-metrics"))

    implementation(Libs.springBootWeb)
    implementation(Libs.micrometerPrometheus)

    testImplementation(Libs.springBootTest)
    testImplementation(Libs.kotestSpring)
}
