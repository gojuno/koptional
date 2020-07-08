dependencies {
    implementation(Library.KotlinStd)
}

dependencies {
    testImplementation(Library.AssertJ)
    testImplementation(Library.JUnitApiJupiter)
    testImplementation(Library.JUnitApiSpek)
    testImplementation(Library.JUnitPlatformCommons)
    testImplementation(Library.KotlinReflect)
}

dependencies {
    testRuntimeOnly(Library.JUnitEngineJupiter)
    testRuntimeOnly(Library.JUnitEngineSpek)
    testRuntimeOnly(Library.JUnitPlatformEngine)
}
