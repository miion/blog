import java.io.File

File("app").walk().maxDepth(1).forEach {
    if (it.name.startsWith("app-") && File(it, "build.gradle.kts").exists()) {
        include("app:${it.name}")
    }
}