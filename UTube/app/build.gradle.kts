plugins {
    alias(libs.plugins.android.application)
    id("com.google.gms.google-services") // Firebase services
}

android {
    namespace = "com.grandstar.utube"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.grandstar.utube"
        minSdk = 23
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildFeatures {
        viewBinding = true
    }
}


dependencies {
    // AppCompat and Material
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)

    // Firebase BOM (ensures Firebase versions match)
    implementation(platform(libs.firebase.bom))

    // Firebase dependencies
    implementation(libs.firebase.auth)
    implementation(libs.firebase.analytics)
    implementation(libs.firebase.storage)
    implementation(libs.firebase.database)

    // Firebase UI for Realtime Database (required for FirebaseRecyclerOptions)
    implementation(libs.firebase.ui.database.v800)

    // Dexter (for permissions handling)
    implementation(libs.dexter)

    // CardView
    implementation(libs.cardview)

    // Media3 ExoPlayer
    implementation (libs.media3.exoplayer)
    implementation (libs.media3.exoplayer.dash)
    implementation (libs.media3.ui)

    // Testing dependencies
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

}
