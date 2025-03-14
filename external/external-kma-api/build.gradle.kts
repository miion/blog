dependencies {
    implementation(project(Projects.Base.http))
    implementation(Libs.springCloudOpenFeign)
    testImplementation(Libs.springBootTest)
    testImplementation(Libs.kotestSpring)
}