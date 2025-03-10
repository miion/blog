import gradle.kotlin.dsl.accessors._8758bf21ec0488ee6f70886b9f0e8378.implementation
import gradle.kotlin.dsl.accessors._8758bf21ec0488ee6f70886b9f0e8378.testImplementation
import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.api.tasks.testing.Test
import org.gradle.api.tasks.testing.logging.TestLogEvent
import org.gradle.kotlin.dsl.*
import java.io.File


class CommonPlugin : Plugin<Project> {

    override fun apply(project: Project) {

        project.repositories {
            this.mavenCentral()
            this.flatDir {
                dirs = setOf(File("${project.rootDir}/buildSrc"))
            }
        }

        project.apply(plugin = "idea")
        project.apply(plugin = "java")
        project.apply(plugin = "java-library")
        project.apply(plugin = "org.springframework.boot")
        project.apply(plugin = "kotlin")
        project.apply(plugin = "org.jetbrains.kotlin.plugin.spring")
//        project.apply(plugin = "kotlin-spring")
        project.apply(plugin = Plugins.springDependencyManagement)

        project.configure<DependencyManagementExtension> {
            imports {
                for (bom in Libs.Bom.definitions) {
                    println(bom)
                    mavenBom(bom)
                }
            }
        }

        project.configure<JavaPluginExtension> {
            sourceCompatibility = JavaVersion.VERSION_17
            targetCompatibility = JavaVersion.VERSION_17
            withSourcesJar()
            withJavadocJar()
        }

        project.dependencies {
            implementation(Libs.kotlinJackson)
            implementation(Libs.kotlinReflect)

            if (project.path != Projects.Common.utils) {
                implementation(project(Projects.Common.utils))
            }
            testImplementation(Libs.kotestJunit)
            testImplementation(Libs.kotestAssertions)
            testImplementation(Libs.mockk)
        }

        project.tasks.withType<Test> {
            this.testLogging {
                this.showStandardStreams = true
            }
            useJUnitPlatform()
            testLogging {
                events(
                    TestLogEvent.FAILED,
                    TestLogEvent.PASSED,
                    TestLogEvent.SKIPPED
                )
            }
        }
    }
}

class CustomizedPlugin : Plugin<Project> {

    override fun apply(root: Project) {
        if (root.rootProject == root) {
            root.subprojects {
                val rawGroup: String by project
                val rawVersion: String by project
                project.group = rawGroup
                project.version = rawVersion

                println(project.name)
//                if (!project.path.matches(Regex("^:[a-z][-0-9a-z]+$"))) {
                extensions.create<CustomizedProjectPluginExtension>("base_project")
                configure<CustomizedProjectPluginExtension> {
                    isApplication = project.name.startsWith("blog")
                }
                configure<CustomizedProjectPluginExtension> {

                }
                this.apply {
                    plugin(CustomizedProjectPlugin::class.java)
                }
//                }
            }
        }
    }
}

class CustomizedProjectPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.apply<CommonPlugin>()

        val extension: CustomizedProjectPluginExtension = project.extensions.getByType()

        if (extension.isApplication) {
            configApplication(project)
        }
    }

}

private fun configApplication(project: Project) {
    println("config application")
    project.apply(plugin = Plugins.springBoot)
    project.dependencies {
        implementation(project(Projects.base))
    }
}

open class CustomizedProjectPluginExtension {
    var isApplication = false
}