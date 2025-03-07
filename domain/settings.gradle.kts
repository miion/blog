import java.io.File

File("domain").walk().maxDepth(1).forEach {
    if (it.name.startsWith("domain-") && File(it, "build.gradle.kts").exists()) {
        include("domain:${it.name}")
    }
}