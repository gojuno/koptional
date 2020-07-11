dependencies {
    implementation(Module.Koptional)
    implementation(Library.KotlinStd)
    implementation(Library.RxJava3)
}

dependencies {
    testImplementation(Library.JUnitApiSpek)
    testImplementation(Library.JUnitPlatformCommons)
    testImplementation(Library.KotlinReflect)
}

dependencies {
    testRuntimeOnly(Library.JUnitEngineSpek)
    testRuntimeOnly(Library.JUnitPlatformEngine)
}
