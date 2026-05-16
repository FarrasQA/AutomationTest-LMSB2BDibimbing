plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

repositories {
    mavenCentral()
}

dependencies {

    // =====================================================
    // TEST FRAMEWORK
    // =====================================================
    testImplementation("org.testng:testng:7.11.0")
    testImplementation("org.assertj:assertj-core:3.27.3")

    // =====================================================
    // UI AUTOMATION (Selenium Core)
    // =====================================================
    implementation("org.seleniumhq.selenium:selenium-java:4.35.0")

    // 🔥 OPTIONAL: DevTools matching Selenium version (FIX CDP WARNING BEST EFFORT)
    implementation("org.seleniumhq.selenium:selenium-devtools-v139:4.35.0")

    // WebDriver Manager
    implementation("io.github.bonigarcia:webdrivermanager:6.3.2")

    // =====================================================
    // API AUTOMATION
    // =====================================================
    testImplementation("io.rest-assured:rest-assured:5.5.0")

    // =====================================================
    // JSON
    // =====================================================
    implementation("com.fasterxml.jackson.core:jackson-databind:2.17.1")

    // =====================================================
    // REPORTING
    // =====================================================
    implementation("com.aventstack:extentreports:5.1.2")
    testImplementation("io.qameta.allure:allure-testng:2.29.0")

    // =====================================================
    // FILE / EXCEL
    // =====================================================
    implementation("org.apache.poi:poi:5.4.1")
    implementation("org.apache.poi:poi-ooxml:5.4.1")
    implementation("commons-io:commons-io:2.15.1")

    // =====================================================
    // LOGGING
    // =====================================================
    implementation("org.apache.logging.log4j:log4j-api:2.25.1")
    implementation("org.apache.logging.log4j:log4j-core:2.25.1")

    implementation("org.slf4j:slf4j-api:2.0.13")
    implementation("org.slf4j:slf4j-simple:2.0.13")

    // =====================================================
    // ENVIRONMENT VARIABLE
    // =====================================================
    implementation("io.github.cdimascio:dotenv-java:3.2.0")

    // =====================================================
    // HTTP CLIENT
    // =====================================================
    implementation("org.apache.httpcomponents.client5:httpclient5:5.4")

    // =====================================================
    // UTILITIES
    // =====================================================
    implementation("org.json:json:20250517")
}

tasks.test {

    useTestNG {

        val suite: String =
            if (project.hasProperty("suite")) {
                project.property("suite") as String
            } else {
                "smoke.xml"
            }

        println("Run test suite: $suite")

        suiteXmlFiles =
            listOf(file("src/test/resources/suites/$suite"))

        if (project.hasProperty("env")) {
            systemProperty("env", project.property("env") as String)
        }

        if (project.hasProperty("browser")) {
            systemProperty("browser", project.property("browser") as String)
        }
    }

    // =====================================================
    // TEST LOGGING
    // =====================================================
    testLogging {

        events(
            "passed",
            "skipped",
            "failed",
            "standardOut",
            "standardError"
        )

        showExceptions = true
        showCauses = true
        showStackTraces = true

        exceptionFormat =
            org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
    }

    systemProperty("file.encoding", "UTF-8")

    minHeapSize = "512m"
    maxHeapSize = "2048m"

    outputs.upToDateWhen { false }
}