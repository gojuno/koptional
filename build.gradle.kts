import com.jfrog.bintray.gradle.BintrayExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        mavenCentral()
        jcenter()
    }

    dependencies {
        plugin(Plugin.Bintray)
        plugin(Plugin.Kotlin)
        plugin(Plugin.Versions)
    }
}

apply {
    plugin(Plugin.Versions.id)
}

subprojects {
    repositories {
        mavenCentral()
    }

    apply {
        plugin(Plugin.Kotlin.id)
        plugin(Plugin.Bintray.id)
        plugin("maven-publish")
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            allWarningsAsErrors = true
        }
    }

    tasks.withType<Test> {
        maxParallelForks = Runtime.getRuntime().availableProcessors() / 2

        reports.junitXml.isEnabled = false

        useJUnitPlatform {
            includeEngines("spek")
        }
    }

    configure<PublishingExtension>() {
        configure(project)
    }

    configure<BintrayExtension>() {
        configure(project)
    }
}
