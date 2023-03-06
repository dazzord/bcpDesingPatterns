plugins {
    id(BuildPlugins.library)
    id(BuildPlugins.jetbrainsKotlinAndroid)
    kotlin(BuildPlugins.kapt)
}

android {
    compileSdk = AndroidSdk.compileSdk
    defaultConfig {
        minSdk = AndroidSdk.min
        targetSdk = AndroidSdk.target
        testInstrumentationRunner = TestLibraries.testIntrumentationRunner

        vectorDrawables.useSupportLibrary = true

        javaCompileOptions {
            annotationProcessorOptions {
                arguments["room.incremental"] = "true"
            }
        }
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
    kapt {
        arguments {
            arg("room.schemaLocation", "$rootDir/schemas")
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

    implementation(Libraries.ktxCore)
    implementation(Libraries.splashScreen)
    implementation(Libraries.composeUi)
    implementation(Libraries.composeMaterial)
    implementation(Libraries.composeUiTooling)
    implementation(Libraries.activityCompose)
    implementation(Libraries.coil)
    implementation(Libraries.imagesCoil)
    implementation(Libraries.koltlinCoroutines)
    implementation(Libraries.ktxRuntimeLifecycle)
    implementation(Libraries.neumorphic)
    implementation(Libraries.pager)
    implementation(Libraries.pagerIndicator)

    /** Tests */
    testImplementation(TestLibraries.junit4)
    testImplementation(TestLibraries.mockk)
    androidTestImplementation(TestLibraries.testJunitExt)
    androidTestImplementation(TestLibraries.testExpreso)
    androidTestImplementation(TestLibraries.composeUiTestJunit)
    debugImplementation(TestLibraries.composeUiToolingTest)
}