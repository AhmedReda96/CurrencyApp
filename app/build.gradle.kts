
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    buildFeatures{
        buildConfig = true
    }
    namespace = "com.example.currencyapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.currencyapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        renderscriptTargetApi= 18
        renderscriptSupportModeEnabled= true

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        debug{
         buildConfigField("String", "BASE_URL", "\"https://pokeapi.co/api/v2/\"")
         buildConfigField("String", "ACCESS_KEY", "\"85bc3df79428a9fad3271f77cc2315bb\"")
        }
        release{
            buildConfigField("String", "BASE_URL", "\"https://pokeapi.co/api/v2/\"")
            buildConfigField("String", "ACCESS_KEY", "\"85bc3df79428a9fad3271f77cc2315bb\"")

            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    buildFeatures {
        dataBinding= true
        viewBinding =true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation("com.google.android.material:material:1.7.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.core:core-ktx:1.12.0-rc01")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // Dagger-Hilt for dependency injection
    implementation("com.google.dagger:hilt-android:2.44.2")
    kapt("com.google.dagger:hilt-android-compiler:2.44.2")    // Networking with retrofit and okHttp
    implementation ("com.squareup.retrofit2:converter-moshi:2.6.2")
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.squareup.okhttp3:okhttp:4.9.3")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.9.3")
    // Coroutine for threads management
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
    // Life cycle
    implementation ("androidx.lifecycle:lifecycle-extensions:2.0.0")
    // NavigationUI dependencies
    implementation ("androidx.navigation:navigation-ui-ktx:2.7.1")
    implementation ("androidx.navigation:navigation-fragment-ktx:2.7.1")
    implementation ("androidx.work:work-runtime:2.8.1")
}