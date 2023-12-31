plugins {
    id(libs.plugins.androidLibrary.get().pluginId)
}
apply<LibraryGradlePlugin>()

android {
    namespace = "com.example.data"
}

dependencies {

    implementation(libs.androidx.compose.runtime)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}