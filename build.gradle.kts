plugins {
    java
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_16
}

group = "ru.mail.polis"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // Annotation
    implementation("org.jetbrains:annotations:22.0.0") {
        because("we need @NotNull, etc.")
    }

    testImplementation("org.seleniumhq.selenium:selenium-java:4.1.2") {
        because("we want to use Selenium to remote control browsers")
    }

    // https://selenide.org/quick-start.html
    implementation("com.codeborne:selenide:6.3.3") {
        because("we want to use Selenide too, to remote control browsers")
    }

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2") {
        because("we want to use JUnit 5 assertions")
    }
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}