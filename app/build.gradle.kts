val projectId = "bcp.design.patterns"

plugins {
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.jetbrainsKotlinAndroid)
    id(BuildPlugins.daggerHilt)
    kotlin(BuildPlugins.kapt)
}

android {
    compileSdk = AndroidSdk.compileSdk
    defaultConfig {
        applicationId = projectId
        minSdk = AndroidSdk.min
        targetSdk = AndroidSdk.target
        versionCode = AndroidSdk.versionCode
        versionName = AndroidSdk.versionName
        testInstrumentationRunner = TestLibraries.testIntrumentationRunner

        vectorDrawables.useSupportLibrary = true

        javaCompileOptions {
            annotationProcessorOptions {
                arguments["room.incremental"] = "true"
            }
        }
    }
    kapt {
        arguments {
            arg("room.schemaLocation", "$rootDir/schemas")
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        getByName("debug") {
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
    kapt {
        correctErrorTypes = true
    }
    kotlinOptions {
        val options = this
        options.jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.composeCompiler
    }
    packagingOptions {
        resources.excludes += "META-INF/AL2.0"
        resources.excludes += "META-INF/LGPL2.1"
    }
}

dependencies {
    implementation(project(":core:coreUi"))
    implementation(project(":core:bcpCore"))

    implementation(project(":features:featureHome"))

    implementation(Libraries.ktxCore)
    implementation(Libraries.composeUi)
    implementation(Libraries.composeViewModel)
    implementation(Libraries.composeMaterial)
    implementation(Libraries.composeMaterial)
    implementation(Libraries.composeUiTooling)
    implementation(Libraries.activityCompose)
    implementation(Libraries.ktxRuntimeLifecycle)
    implementation(Libraries.koltlinCoroutines)
    implementation(Libraries.kotlinCoroutinesAndroid)
    implementation(Libraries.hiltNavigation)
    implementation(Libraries.coil)
    implementation(Libraries.splashScreen)
    implementation(Libraries.navigation)
    implementation(Libraries.accompanist)
    implementation(Libraries.permissions)

    /** Dagger Hilt */
    implementation(Libraries.hiltandorid)
    kapt(Libraries.hiltkapt)

    /** Tests */
    testImplementation(TestLibraries.junit4)
    testImplementation(TestLibraries.mockk)
    androidTestImplementation(TestLibraries.testJunitExt)
    androidTestImplementation(TestLibraries.testExpreso)
    androidTestImplementation(TestLibraries.composeUiTestJunit)
    debugImplementation(TestLibraries.composeUiToolingTest)

}