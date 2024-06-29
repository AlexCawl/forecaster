plugins {
    id("library-convention")
}

android {
    namespace = "org.alexcawl.forecaster.locations"
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:data"))
    implementation(project(":core:network"))
    implementation(project(":core:ui"))
}