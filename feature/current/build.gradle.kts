plugins {
    id("library-convention")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "org.alexcawl.forecaster.current"
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:data"))
    implementation(project(":core:network"))
    implementation(project(":core:ui"))
}