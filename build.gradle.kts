plugins {
    java
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
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

    // https://selenide.org/quick-start.html
    implementation("com.codeborne:selenide:6.3.3") {
        because("we want to use Selenide too, to remote control browsers")
    }

    implementation("ru.yandex.qatools.matchers:webdriver-matchers:1.4.1") {
        because("we were asked to")
    }
    implementation("ru.yandex.qatools.matchers:collection-matchers:1.4.1") {
        because("we were asked to")
    }

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2") {
        because("we want to use JUnit 5 assertions")
    }

    testImplementation("org.junit.jupiter:junit-jupiter-params:5.8.2") {
        because("parametrized test")
    }

    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks.test {
    useJUnitPlatform()
}