import com.android.build.gradle.internal.dsl.BuildType

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.android.kotlin)
    id("android-publish")
    id("kotlin-parcelize")
}

android {
    compileSdk = libs.versions.sdk.compile.get().toInt()

    defaultConfig {
        minSdk = libs.versions.sdk.min.get().toInt()
        targetSdk = libs.versions.sdk.target.get().toInt()
        buildToolsVersion = libs.versions.buildtools.get()
        consumerProguardFiles("consumer-rules.pro")
        
    }

    resourcePrefix("commons_")

    buildTypes {
        getByName("debug") {
            (this as BuildType).isDebuggable = true
            isMinifyEnabled = false
            jniDebuggable(true)
        }

        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    buildFeatures {
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.toVersion(libs.versions.java.get())
        targetCompatibility = JavaVersion.toVersion(libs.versions.java.get())
    }

    kotlinOptions {
        jvmTarget = libs.versions.java.get()
    }

    testOptions {
        unitTests {
            animationsDisabled = true
            isIncludeAndroidResources = true
            isReturnDefaultValues = true
        }
    }

    lint {
        checkReleaseBuilds = false
        abortOnError = false
    }
}


tasks.withType<Test> {
    useJUnitPlatform()
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar", "*.aar"))))


    // Kotlin
    implementation(libs.kotlin.stdlib)
    implementation(libs.kotlin.coroutines.core)

    // Google
    implementation(libs.google.material)
    implementation(libs.google.gson)

    // AndroidX
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment)
    implementation(libs.androidx.navigation.ui)
    implementation(libs.androidx.recyclerview)
    
    // Unit Test
    testImplementation(libs.test.mockk)
    testImplementation(libs.test.junitjupiter.api)
    testImplementation(libs.test.junitjupiter.engine)
    testImplementation(libs.test.coretesting)
    testImplementation(libs.test.coroutinestesting)
}
