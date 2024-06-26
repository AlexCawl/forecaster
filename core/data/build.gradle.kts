plugins {
    id("core-data-convention")
}

android {
    namespace = "org.alexcawl.forecaster.data"
}

dependencies {
    implementation(project(":core:common"))
}
