plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("com.google.devtools.ksp").version("2.0.0-1.0.21")
    kotlin("kapt")
}


android {
    buildFeatures {
        dataBinding = true
    }

    namespace = "com.example.lab_week_13"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.test_lab_week_12"
        minSdk = 24
        targetSdk = 36
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}


dependencies {
    val moshiVersion = "1.15.1" // Tambahkan variabel versi
    val retrofitVersion = "2.9.0" // Pastikan versi Retrofit

    // Retrofit & Moshi
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion") // (Menggantikan libs.retrofit)
    implementation("com.squareup.retrofit2:converter-moshi:$retrofitVersion") // (Menggantikan libs.converter.moshi)
    implementation("com.squareup.moshi:moshi-kotlin:$moshiVersion")
    kapt("com.squareup.moshi:moshi-kotlin-codegen:$moshiVersion") // (Menggantikan libs.moshi.kotlin.codegen)

    // Coroutines
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)

    // LiveData & ViewModel
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    // UI/Basic Android Components (Biarkan ini menggunakan libs jika sudah ada)
    implementation(libs.androidx.recyclerview)
    implementation(libs.glide)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    val roomVersion = "2.6.1"
    implementation("androidx.room:room-runtime:$roomVersion")
    implementation("androidx.room:room-ktx:$roomVersion")
    kapt("androidx.room:room-compiler:$roomVersion")
}
