import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

dependencies {
    implementation(Module.Koptional)
    implementation(Library.KotlinStd)
    implementation(Library.ReactorCore)
}

dependencies {
    testImplementation(Library.JUnitApiSpek)
    testImplementation(Library.JUnitPlatformCommons)
    testImplementation(Library.KotlinReflect)
    testImplementation(Library.ReactorTest)
}

dependencies {
    testRuntimeOnly(Library.JUnitEngineSpek)
    testRuntimeOnly(Library.JUnitPlatformEngine)
}

tasks.withType<KotlinCompile> {
    if (name.contains("test", ignoreCase = true)) {
        kotlinOptions {
            // Reactor test API is exposed as interface static methods which requires Java 8+.
            jvmTarget = "1.8"
        }
    }
}
