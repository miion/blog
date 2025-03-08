import java.io.File

File("external").walk().maxDepth(1).forEach {
    if (it.name.startsWith("external-") && File(it, "build.gradle.kts").exists()) {
        include("external:${it.name}")
    }
}