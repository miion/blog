dependencies {
    implementation(project(":app"))

    implementation(Libs.springBootWeb)
}

springBoot {
    // Define the Fully Qualified Name for the application main class
    // (Note that Kotlin compiles `App.kt` to a class with FQN `com.example.app.AppKt`.)
    mainClass = "org.mion.blog.Application"
}