/*
 * This file was generated by the Gradle 'init' task.
 *
 * The settings file is used to specify which projects to include in your build.
 *
 * Detailed information about configuring a multi-project build in Gradle can be found
 * in the user manual at https://docs.gradle.org/7.2/userguide/multi_project_builds.html
 */

//
// https://docs.gradle.org/current/userguide/plugins.html#sec:plugin_management
//
pluginManagement {

    val springBootVer: String by settings
    val dependencyManagementVer: String by settings
    val lombokPluginVer: String by settings

    plugins {
        id("org.springframework.boot") version springBootVer
        id("io.spring.dependency-management") version dependencyManagementVer
        id("io.freefair.lombok") version lombokPluginVer
    }
}

rootProject.name = "hellojpa"

include("app")
include("list")
include("utilities")
