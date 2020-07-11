dependencies {
    implementation(Module.Koptional)
    implementation(Library.KotlinStd)
    implementation(Library.RxJava2)
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
