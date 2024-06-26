plugins {
    id("core-ui-convention")
}

android {
    namespace = "org.alexcawl.forecaster.ui"
}

dependencies {
    implementation(project(":core:common"))
}
