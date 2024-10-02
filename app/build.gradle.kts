plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.myproyect.gestornovelasnjr"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.myproyect.gestornovelasnjr"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        javaCompileOptions {
            annotationProcessorOptions {
                arguments.put("room.schemaLocation", "$projectDir/schemas")
            }
        }
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
}

dependencies {
    implementation(platform("com.google.firebase:firebase-bom:33.3.0"))
    implementation("com.google.firebase:firebase-firestore")

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.recyclerview:recyclerview:1.3.1")
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel:2.6.2")
    implementation("androidx.lifecycle:lifecycle-livedata:2.6.2")



    implementation("androidx.work:work-runtime:2.8.1")
    implementation("androidx.core:core-ktx:1.12.0")

    // Otras dependencias...
}

apply(plugin = "com.google.gms.google-services")
