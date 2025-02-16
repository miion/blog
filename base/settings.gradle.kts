import java.io.File

File("base").walk().maxDepth(1).forEach {
    if (it.name.startsWith("base-") && File(it, "build.gradle.kts").exists()) {
        include("base:${it.name}")
    }
}