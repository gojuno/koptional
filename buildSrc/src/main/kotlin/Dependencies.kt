import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.api.initialization.dsl.ScriptHandler
import org.gradle.kotlin.dsl.project

enum class Library(group: String, artifact: String, internal val version: Version) {
    AssertJ("org.assertj", "assertj-core", Version.AssertJ),
    JUnitApiJupiter("org.junit.jupiter", "junit-jupiter-api", Version.JUnitJupiter),
    JUnitApiSpek("org.jetbrains.spek", "spek-api", Version.JUnitSpek),
    JUnitEngineJupiter("org.junit.jupiter", "junit-jupiter-engine", Version.JUnitJupiter),
    JUnitEngineSpek("org.jetbrains.spek", "spek-junit-platform-engine", Version.JUnitSpek),
    JUnitPlatformCommons("org.junit.platform", "junit-platform-commons", Version.JUnitPlatform),
    JUnitPlatformEngine("org.junit.platform", "junit-platform-engine", Version.JUnitPlatform),
    KotlinReflect("org.jetbrains.kotlin", "kotlin-reflect", Version.Kotlin),
    KotlinStd("org.jetbrains.kotlin", "kotlin-stdlib", Version.Kotlin),
    ReactorCore("io.projectreactor", "reactor-core", Version.Reactor),
    ReactorTest("io.projectreactor", "reactor-test", Version.Reactor),
    RxJava2("io.reactivex.rxjava2", "rxjava", Version.RxJava2),
    RxJava3("io.reactivex.rxjava3", "rxjava", Version.RxJava3),
    ;

    internal val notation = "$group:$artifact:${version.value}"

    internal enum class Version(val value: String) {
        AssertJ("3.16.1"),
        JUnitJupiter("5.6.2"),
        JUnitPlatform("1.6.2"),
        JUnitSpek("1.1.5"),
        Kotlin("1.3.72"),
        Reactor("3.3.7.RELEASE"),
        RxJava2("2.2.19"),
        RxJava3("3.0.4"),
    }
}

fun DependencyHandler.implementation(library: Library) = add("implementation", library.notation)
fun DependencyHandler.testImplementation(library: Library) = add("testImplementation", library.notation)
fun DependencyHandler.testRuntimeOnly(library: Library) = add("testRuntimeOnly", library.notation)

enum class Plugin(val id: String, group: String, artifact: String, version: Version) {
    Bintray("com.jfrog.bintray", "com.jfrog.bintray.gradle", "gradle-bintray-plugin", Version.Bintray),
    Kotlin("org.jetbrains.kotlin.jvm", "org.jetbrains.kotlin", "kotlin-gradle-plugin", Version.Kotlin),
    Versions("com.github.ben-manes.versions", "com.github.ben-manes", "gradle-versions-plugin", Version.Versions),
    ;

    internal val notation = "$group:$artifact:${version.value}"

    private enum class Version(val value: String) {
        Bintray("1.8.5"),
        Kotlin(Library.KotlinStd.version.value),
        Versions("0.28.0"),
    }
}

fun DependencyHandler.plugin(plugin: Plugin) = add(ScriptHandler.CLASSPATH_CONFIGURATION, plugin.notation)

enum class Module(internal val id: String) {
    Koptional(":koptional"),
}

fun DependencyHandler.implementation(module: Module) = add("implementation", project(module.id))
