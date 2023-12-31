/*
 * This file was generated by the Gradle 'init' task.
 *
 * This project uses @Incubating APIs which are subject to change.
 */

plugins {
    kotlin("jvm") version "1.9.0"
    `java-library`
    `maven-publish`
}

kotlin {
    jvmToolchain(17)
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.8.20")
    implementation("org.seleniumhq.selenium:selenium-java:4.10.0")
    implementation("org.seleniumhq.selenium:selenium-chrome-driver:4.10.0")
    implementation("com.amazonaws:aws-lambda-java-events:3.11.1")
    implementation("com.amazonaws:aws-lambda-java-core:1.2.2")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5:1.8.20")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.8.2")
}

group = "org.example"
version = "1.0-SNAPSHOT"
description = "consoleApp"
java.sourceCompatibility = JavaVersion.VERSION_17

//publishing {
//    publications.create<MavenPublication>("maven") {
//        from(components["java"])
//    }
//}

tasks.withType<JavaCompile>() {
    options.encoding = "UTF-8"
}

tasks.withType<Javadoc>() {
    options.encoding = "UTF-8"
}

tasks.register<Copy>("copyRuntimeDependencies") {
    from(configurations.runtimeClasspath)
    into("build/dependency")
}

tasks.build{
    dependsOn("copyRuntimeDependencies")
}
