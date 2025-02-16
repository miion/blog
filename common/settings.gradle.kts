import java.io.File

File("common").walk().maxDepth(1).forEach {
    if (it.name.startsWith("common-") && File(it, "build.gradle.kts").exists()) {
        include("common:${it.name}")
    }
}