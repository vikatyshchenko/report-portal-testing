import org.gradle.api.tasks.testing.logging.TestExceptionFormat

group = "com.report.portal"
version = "1.0-SNAPSHOT"
val log4jVersion = "2.17.1"
val slf4jVersion = "2.0.7"
val lombokVersion = "1.18.20"
val rpJavaClientVersion = "5.1.17"
val rpTestNGVersion = "5.1.4"
val rpLog4jVersion = "5.1.6"
val rpAllureVersion = "5.1.0"
val selenideVersion = "6.13.0"
val cucumberVersion = "7.12.0"

plugins {
    id("java")
    id("io.qameta.allure") version "2.10.0"
    id("io.freefair.lombok") version "8.0.1"
    id("org.sonarqube") version "4.0.0.2929"
}

sonar {
    properties {
        property("sonar.projectKey", "report-portal-testing")
        property("sonar.projectName", "report-portal-testing")
        property("sonar.host.url", "http://localhost:9000")
        property("sonar.token", "sqp_335b98d52d7aec283a16ec9651a7488888da3ce4")
    }
}


buildscript {
    repositories {
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
    }
    dependencies {
        classpath("io.freefair.gradle:lombok-plugin:8.0.1")
    }
}

apply(plugin = "io.freefair.lombok")

repositories {
    mavenCentral()
    maven {
        url = uri("https://repo.maven.apache.org")
        metadataSources {
            mavenPom()
            artifact()
            ignoreGradleMetadataRedirection()
        }
    }
}

dependencies {
    // https://mvnrepository.com/artifact/org.testng/testng
    implementation("org.testng:testng:7.7.0")
    implementation("org.apache.logging.log4j:log4j-api:$log4jVersion")
    implementation("org.apache.logging.log4j:log4j-core:$log4jVersion")
    testImplementation("org.slf4j:slf4j-log4j12:$slf4jVersion")
    testImplementation("org.slf4j:slf4j-simple:$slf4jVersion")
    implementation("com.codeborne:selenide:$selenideVersion")
    implementation("io.qameta.allure:allure-testng:${allure.version}")
    implementation("com.epam.reportportal:client-java:$rpJavaClientVersion")
    implementation("com.epam.reportportal:agent-java-testng:$rpTestNGVersion")
    implementation("com.epam.reportportal:logger-java-log4j:$rpLog4jVersion")
    implementation("io.cucumber:cucumber-java:$cucumberVersion")
    implementation("io.cucumber:cucumber-testng:$cucumberVersion")
    runtimeOnly("com.epam.reportportal:allure-common:$rpAllureVersion")
}

allure {
    version.value("2.21.0")
    report {
        reportDir.set(project.reporting.baseDirectory.dir("report-portal-testing/build/allure-results"))
    }
}

tasks.test {
    val testResults = mutableListOf<String>()

    useTestNG()

    testLogging {
        events("PASSED", "FAILED", "SKIPPED", "STANDARD_ERROR")
        exceptionFormat = TestExceptionFormat.FULL
    }
    doLast {
        if (testResults.isNotEmpty()) {
            printResults(testResults)
        }
    }

    beforeTest(closureOf<TestDescriptor> { logger.lifecycle("Test: $this") })

    afterTest(KotlinClosure2(
            { descriptor: TestDescriptor, result: TestResult ->
                println("[${descriptor.className}] > ${descriptor.displayName}: ${result.resultType}")
            }
    ))

    finalizedBy("allureReport")
}

fun printResults(allResults: List<String>) {
    val maxLength = allResults.flatMap { it.lines() }.maxOf { it.length }

    println("┌${"─".repeat(maxLength)}┐")

    println(allResults.joinToString(separator = "\n") {
        it.lines().joinToString(separator = "\n") {
            "│$it${" ".repeat(maxLength - it.length)}│"
        }
    })

    println("└${"─".repeat(maxLength)}┘")
}




