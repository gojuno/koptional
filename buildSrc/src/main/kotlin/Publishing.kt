import org.gradle.api.Project
import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.api.tasks.SourceSetContainer
import org.gradle.jvm.tasks.Jar
import org.gradle.kotlin.dsl.create
import org.gradle.kotlin.dsl.get

internal const val PUBLICATION_NAME = "koptional-publication"

fun PublishingExtension.configure(project: Project) {
    publications {
        create<MavenPublication>(PUBLICATION_NAME) {
            from(project.components["java"])

            groupId = "com.gojuno.koptional"
            artifactId = project.name
            version = project.gitVersion()

            artifact(createSourcesTask(project))

            pom {
                name.set(project.name)
                description.set(project.description)
                url.set("https://github.com/gojuno/koptional")

                developers {
                    developer {
                        id.set("gojuno")
                        name.set("Juno Inc.")
                        email.set("opensource@gojuno.com")
                    }
                }

                licenses {
                    license {
                        distribution.set("repo")
                        name.set("The Apache Software License, Version 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
            }
        }
    }
}

private fun createSourcesTask(project: Project) = project.tasks.create("sourcesJar", Jar::class) {
    archiveClassifier.set("sources")

    val sourceSets = project.extensions.findByName("sourceSets") as SourceSetContainer
    val sourceSet = sourceSets.getByName("main")

    dependsOn("classes")
    from(sourceSet.allSource)
}
