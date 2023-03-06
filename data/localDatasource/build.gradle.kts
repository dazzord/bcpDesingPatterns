plugins {
    id(BuildPlugins.library)
    id(BuildPlugins.jetbrainsKotlinAndroid)
    id(BuildPlugins.daggerHilt)
    kotlin(BuildPlugins.kapt)
}

android {
    compileSdk = AndroidSdk.compileSdk
    defaultConfig {
        minSdk = AndroidSdk.min
        targetSdk = AndroidSdk.target
        testInstrumentationRunner = TestLibraries.testIntrumentationRunner

        vectorDrawables.useSupportLibrary = true

    }
    buildTypes {
        getByName("release") {
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
    kotlinOptions {
        val options = this
        options.jvmTarget = AndroidSdk.kotlinCompileTargetVersion
    }
    packagingOptions {
        resources.excludes += "META-INF/AL2.0"
        resources.excludes += "META-INF/LGPL2.1"
    }
}

dependencies {

    implementation(project(":core:coreUi"))
    implementation(project(":core:bcpCore"))

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
    implementation(Libraries.deviceUtils)

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