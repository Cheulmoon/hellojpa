/*
 * This file was generated by the Gradle 'init' task.
 */

import org.springframework.boot.gradle.tasks.bundling.BootJar;

plugins {
    id("library-conventions")
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    id("io.freefair.lombok")
}

/* domain 의 경우에만 추가 (라이브러리) */
tasks.getByName<BootJar>("bootJar") {
    enabled = false
}
tasks.getByName<Jar>("jar") {
    enabled = true
}

dependencies {
    api(project(":hellojpa-core"))

    //
    // Persistence
    //
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("com.querydsl:querydsl-apt")
    implementation("com.querydsl:querydsl-jpa")
    annotationProcessor(group="com.querydsl", name="querydsl-apt", classifier="jpa")
    annotationProcessor("jakarta.persistence:jakarta.persistence-api")
    annotationProcessor("jakarta.annotation:jakarta.annotation-api")

    runtimeOnly("org.postgresql:postgresql")
}
