import org.springframework.boot.gradle.plugin.SpringBootPlugin

plugins {
    alias(libs.plugins.kotlin.jpa)
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.spring)
    alias(libs.plugins.spring.dependency.management)
}

dependencyManagement {
    imports {
        mavenBom(SpringBootPlugin.BOM_COORDINATES)
    }
}

dependencies {
    implementation(libs.spring.boot.starter.data.jpa)
    implementation(project(":shared"))
    runtimeOnly(libs.postgresql)
    testRuntimeOnly(libs.h2)
}

tasks.register("prepareKotlinBuildScriptModel"){}

// tasks.withType<JavaCompile>().configureEach {
// options.compilerArgs.add("-parameters")
// }
