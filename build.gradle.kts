/*
 * TUI4J Root Build
 */

import org.gradle.api.attributes.java.TargetJvmEnvironment

plugins {
    id("java-library")
    id("maven-publish")
    signing
    id("com.gradleup.nmcp") version "1.2.1"
}

description = "TUI4J"

group = providers.gradleProperty("group").orNull ?: "com.williamcallahan"
version = providers.gradleProperty("version").orNull ?: "0.0.0-SNAPSHOT"

repositories {
    mavenCentral {
        // Avoid Gradle metadata variant selection issues (e.g., snakeyaml android classifier).
        metadataSources {
            mavenPom()
            artifact()
        }
    }
}

dependencies {
    components {
        withModule("org.yaml:snakeyaml") {
            allVariants {
                attributes.attribute(
                    TargetJvmEnvironment.TARGET_JVM_ENVIRONMENT_ATTRIBUTE,
                    objects.named(TargetJvmEnvironment.STANDARD_JVM)
                )
            }
        }
    }
}

// Ensure we resolve standard JVM variants (avoid Android-only variants).
configurations.configureEach {
    attributes.attribute(
        TargetJvmEnvironment.TARGET_JVM_ENVIRONMENT_ATTRIBUTE,
        objects.named(TargetJvmEnvironment.STANDARD_JVM)
    )
}

configurations.matching { it.name.startsWith("examples") && it.isCanBeResolved }.configureEach {
    attributes.attribute(
        TargetJvmEnvironment.TARGET_JVM_ENVIRONMENT_ATTRIBUTE,
        objects.named(TargetJvmEnvironment.STANDARD_JVM)
    )
}

dependencies {
    api(libs.org.jline.jline.terminal.jni)
    api(libs.com.ibm.icu.icu4j)
    api(libs.org.apache.commons.commons.text)
    api(libs.org.apache.commons.commons.lang3)
    
    testImplementation(libs.org.junit.jupiter.junit.jupiter)
    testImplementation(libs.org.mockito.mockito.core)
    testImplementation(libs.org.mockito.mockito.junit.jupiter)
    testImplementation(libs.org.assertj.assertj.core)
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
    withSourcesJar()
    withJavadocJar()
}

sourceSets {
    val main by getting

    fun findExampleProjectDirs(rootPath: String): List<File> =
        file(rootPath)
            .listFiles()
            ?.filter { it.isDirectory }
            .orEmpty()

    fun org.gradle.api.file.SourceDirectorySet.addIfExists(dir: File) {
        if (dir.exists()) {
            srcDir(dir)
        }
    }

    // Examples organized by upstream Charmbracelet repo:
    // - examples/bubbletea/ - Bubble Tea framework examples
    // - examples/bubbles/   - Bubbles component examples
    // - examples/lipgloss/  - Lipgloss styling examples
    // - examples/harmonica/ - Harmonica animation examples
    // - examples/x/         - x/ansi experimental examples
    // - examples/spring/    - Spring integration (not a Charm repo)

    val bubbleteaExampleProjectDirs = findExampleProjectDirs("examples/bubbletea")

    val examplesBubbletea by creating {
        java.srcDir("examples/bubbletea/src/main/java")
        resources.srcDir("examples/bubbletea/src/main/resources")
        java.srcDir("src/main/resources/examples/compat/bubble-tea")

        bubbleteaExampleProjectDirs.forEach { dir ->
            java.addIfExists(dir.resolve("src/main/java"))
            resources.addIfExists(dir.resolve("src/main/resources"))
        }

        compileClasspath += main.output + configurations["examplesBubbleteaCompileClasspath"]
        runtimeClasspath += output + compileClasspath + configurations["examplesBubbleteaRuntimeClasspath"]
    }

    // Source sets for each Charmbracelet repo
    val bubblesExampleProjectDirs = findExampleProjectDirs("examples/bubbles")
    val examplesBubbles by creating {
        java.srcDir("examples/bubbles/src/main/java")
        resources.srcDir("examples/bubbles/src/main/resources")
        bubblesExampleProjectDirs.forEach { dir ->
            java.addIfExists(dir.resolve("src/main/java"))
            resources.addIfExists(dir.resolve("src/main/resources"))
        }
        compileClasspath += main.output + configurations["examplesBubblesCompileClasspath"]
        runtimeClasspath += output + compileClasspath + configurations["examplesBubblesRuntimeClasspath"]
    }

    val lipglossExampleProjectDirs = findExampleProjectDirs("examples/lipgloss")
    val examplesLipgloss by creating {
        java.srcDir("examples/lipgloss/src/main/java")
        resources.srcDir("examples/lipgloss/src/main/resources")
        lipglossExampleProjectDirs.forEach { dir ->
            java.addIfExists(dir.resolve("src/main/java"))
            resources.addIfExists(dir.resolve("src/main/resources"))
        }
        compileClasspath += main.output + configurations["examplesLipglossCompileClasspath"]
        runtimeClasspath += output + compileClasspath + configurations["examplesLipglossRuntimeClasspath"]
    }

    val harmonicaExampleProjectDirs = findExampleProjectDirs("examples/harmonica")
    val examplesHarmonica by creating {
        java.srcDir("examples/harmonica/src/main/java")
        resources.srcDir("examples/harmonica/src/main/resources")
        harmonicaExampleProjectDirs.forEach { dir ->
            java.addIfExists(dir.resolve("src/main/java"))
            resources.addIfExists(dir.resolve("src/main/resources"))
        }
        compileClasspath += main.output + configurations["examplesHarmonicaCompileClasspath"]
        runtimeClasspath += output + compileClasspath + configurations["examplesHarmonicaRuntimeClasspath"]
    }

    val xExampleProjectDirs = findExampleProjectDirs("examples/x")
    val examplesX by creating {
        java.srcDir("examples/x/src/main/java")
        resources.srcDir("examples/x/src/main/resources")
        xExampleProjectDirs.forEach { dir ->
            java.addIfExists(dir.resolve("src/main/java"))
            resources.addIfExists(dir.resolve("src/main/resources"))
        }
        compileClasspath += main.output + configurations["examplesXCompileClasspath"]
        runtimeClasspath += output + compileClasspath + configurations["examplesXRuntimeClasspath"]
    }

    val examplesSpringIntegration by creating {
        java.srcDir("examples/spring/src/main/java")
        resources.srcDir("examples/spring/src/main/resources")
        java.srcDir("src/main/resources/examples/spring")
        compileClasspath += main.output + configurations["examplesSpringIntegrationCompileClasspath"]
        runtimeClasspath += output + compileClasspath + configurations["examplesSpringIntegrationRuntimeClasspath"]
    }

    val examplesBubbleteaTest by creating {
        java.srcDir("examples/bubbletea/src/test/java")
        resources.srcDir("examples/bubbletea/src/test/resources")

        bubbleteaExampleProjectDirs.forEach { dir ->
            java.addIfExists(dir.resolve("src/test/java"))
            resources.addIfExists(dir.resolve("src/test/resources"))
        }

        compileClasspath += main.output + examplesBubbletea.output + configurations["examplesBubbleteaTestCompileClasspath"]
        runtimeClasspath += output + compileClasspath + configurations["examplesBubbleteaTestRuntimeClasspath"]
    }

    val examplesSpringIntegrationTest by creating {
        java.srcDir("examples/spring/src/test/java")
        resources.srcDir("examples/spring/src/test/resources")
        compileClasspath += main.output + examplesSpringIntegration.output + configurations["examplesSpringIntegrationTestCompileClasspath"]
        runtimeClasspath += output + compileClasspath + configurations["examplesSpringIntegrationTestRuntimeClasspath"]
    }
}

tasks.register("examplesClasses") {
    group = "build"
    description = "Compiles all example source sets."
    dependsOn(
        "examplesBubbleteaClasses",
        "examplesBubblesClasses",
        "examplesLipglossClasses",
        "examplesHarmonicaClasses",
        "examplesXClasses",
        "examplesSpringIntegrationClasses"
    )
}

tasks.named<Test>("test") {
    dependsOn("examplesClasses")
    dependsOn("examplesBubbleteaTest", "examplesSpringIntegrationTest")
}

tasks.named<JavaCompile>("compileExamplesSpringIntegrationJava") {
    options.annotationProcessorPath = configurations["examplesSpringIntegrationAnnotationProcessor"]
}

dependencies {
    "examplesBubbleteaImplementation"(sourceSets.main.get().output)
    "examplesBubbleteaImplementation"(libs.com.squareup.okhttp3.okhttp)
    configurations["examplesBubbleteaRuntimeClasspath"].extendsFrom(
        configurations.api.get(),
        configurations.runtimeClasspath.get()
    )

    "examplesBubblesImplementation"(sourceSets.main.get().output)
    configurations["examplesBubblesRuntimeClasspath"].extendsFrom(
        configurations.api.get(),
        configurations.runtimeClasspath.get()
    )

    "examplesLipglossImplementation"(sourceSets.main.get().output)
    configurations["examplesLipglossRuntimeClasspath"].extendsFrom(
        configurations.api.get(),
        configurations.runtimeClasspath.get()
    )

    "examplesHarmonicaImplementation"(sourceSets.main.get().output)
    configurations["examplesHarmonicaRuntimeClasspath"].extendsFrom(
        configurations.api.get(),
        configurations.runtimeClasspath.get()
    )

    "examplesXImplementation"(sourceSets.main.get().output)
    configurations["examplesXRuntimeClasspath"].extendsFrom(
        configurations.api.get(),
        configurations.runtimeClasspath.get()
    )

    "examplesSpringIntegrationImplementation"(platform("org.springframework.boot:spring-boot-dependencies:3.5.9"))
    "examplesSpringIntegrationImplementation"(sourceSets.main.get().output)
    "examplesSpringIntegrationImplementation"(libs.org.springframework.boot.spring.boot.starter.data.jpa) {
        exclude(group = "org.yaml", module = "snakeyaml")
    }
    "examplesSpringIntegrationImplementation"(libs.com.github.javafaker.javafaker) {
        exclude(group = "org.yaml", module = "snakeyaml")
    }
    "examplesSpringIntegrationImplementation"("org.yaml:snakeyaml:2.3@jar")
    "examplesSpringIntegrationRuntimeOnly"(libs.com.h2database.h2)
    "examplesSpringIntegrationCompileOnly"(libs.org.projectlombok.lombok)
    "examplesSpringIntegrationAnnotationProcessor"(libs.org.projectlombok.lombok)
}

configurations["examplesBubbleteaTestImplementation"].extendsFrom(
    configurations["examplesBubbleteaImplementation"],
    configurations["testImplementation"]
)
configurations["examplesBubbleteaTestRuntimeOnly"].extendsFrom(
    configurations["examplesBubbleteaRuntimeOnly"],
    configurations["testRuntimeOnly"]
)
configurations["examplesSpringIntegrationTestImplementation"].extendsFrom(
    configurations["examplesSpringIntegrationImplementation"],
    configurations["testImplementation"]
)
configurations["examplesSpringIntegrationTestRuntimeOnly"].extendsFrom(
    configurations["examplesSpringIntegrationRuntimeOnly"],
    configurations["testRuntimeOnly"]
)

tasks.register<Test>("examplesBubbleteaTest") {
    description = "Runs tests for Bubble Tea examples."
    group = "verification"
    testClassesDirs = sourceSets["examplesBubbleteaTest"].output.classesDirs
    classpath = sourceSets["examplesBubbleteaTest"].runtimeClasspath
}

tasks.register<Test>("examplesSpringIntegrationTest") {
    description = "Runs tests for Spring integration examples."
    group = "verification"
    testClassesDirs = sourceSets["examplesSpringIntegrationTest"].output.classesDirs
    classpath = sourceSets["examplesSpringIntegrationTest"].runtimeClasspath
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
    testLogging {
        events(
            org.gradle.api.tasks.testing.logging.TestLogEvent.FAILED,
            org.gradle.api.tasks.testing.logging.TestLogEvent.SKIPPED
        )
        exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.SHORT
        showStandardStreams = false
    }
}

tasks.withType<Test>().configureEach {
    afterSuite(KotlinClosure2<TestDescriptor, TestResult, Unit>({ desc, result ->
        if (desc.parent == null) {
            logger.lifecycle(
                "TESTS: ${result.resultType} (${result.testCount} tests, " +
                    "${result.successfulTestCount} passed, " +
                    "${result.failedTestCount} failed, " +
                    "${result.skippedTestCount} skipped)"
            )
        }
    }))
}

tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
}

tasks.withType<Javadoc>().configureEach {
    options.encoding = "UTF-8"
}

tasks.register<Jar>("examplesJar") {
    group = "build"
    description = "Creates a fat JAR with all example classes and dependencies"
    archiveFileName.set("tui4j-examples.jar")
    destinationDirectory.set(layout.buildDirectory.dir("libs"))

    duplicatesStrategy = DuplicatesStrategy.EXCLUDE

    manifest {
        attributes["Main-Class"] = "com.williamcallahan.tui4j.examples.ExamplesRunner"
    }

    from(sourceSets["examplesBubbletea"].output)
    from(sourceSets["examplesBubbles"].output)
    from(sourceSets["examplesLipgloss"].output)
    from(sourceSets["examplesHarmonica"].output)
    from(sourceSets["examplesX"].output)
    from(sourceSets["examplesSpringIntegration"].output)
    from(sourceSets.main.get().output)

    val examplesRuntimeClasspaths = listOf(
        configurations["examplesBubbleteaRuntimeClasspath"],
        configurations["examplesBubblesRuntimeClasspath"],
        configurations["examplesLipglossRuntimeClasspath"],
        configurations["examplesHarmonicaRuntimeClasspath"],
        configurations["examplesXRuntimeClasspath"],
        configurations["examplesSpringIntegrationRuntimeClasspath"]
    )

    examplesRuntimeClasspaths.forEach { runtimeClasspath ->
        runtimeClasspath.filter { it.isFile && it.name.endsWith(".jar") }.forEach { file ->
            from(zipTree(file)) {
                exclude("META-INF/MANIFEST.MF")
                exclude("META-INF/INDEX.LIST")
                exclude("META-INF/io.netty.versions.properties")
                exclude("META-INF/DEPENDENCIES")
                exclude("META-INF/LICENSE")
                exclude("META-INF/NOTICE")
                exclude("META-INF/*.SF")
                exclude("META-INF/*.DSA")
                exclude("META-INF/*.RSA")
            }
        }
    }
}

tasks.register("copyAllExampleJars") {
    group = "build"
    description = "Copies the examples JAR to all example directories"
    dependsOn("examplesJar")

    val jarPath = layout.buildDirectory.get().dir("libs").file("tui4j-examples.jar").asFile

    // Dynamically find all example subdirectories that have src/main/java
    val exampleRoots = listOf(
        file("${projectDir}/examples/bubbletea"),
        file("${projectDir}/examples/bubbles"),
        file("${projectDir}/examples/lipgloss"),
        file("${projectDir}/examples/harmonica"),
        file("${projectDir}/examples/x"),
        file("${projectDir}/examples/spring")
    )

    doLast {
        exampleRoots.forEach { root ->
            if (root.exists()) {
                // Copy to root
                project.copy {
                    from(jarPath)
                    into(root)
                }
                // Copy to each subdirectory that has src/main/java
                root.listFiles()?.filter { it.isDirectory && it.resolve("src/main/java").exists() }?.forEach { subdir ->
                    project.copy {
                        from(jarPath)
                        into(subdir)
                    }
                }
            }
        }
    }
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
            artifactId = "tui4j"
            
            pom {
                name.set("TUI4J")
                description.set("TUI4J: Terminal User Interface library for Java that includes Bubble Tea ported from Go")
                url.set("https://github.com/WilliamAGH/tui4j")

                licenses {
                    license {
                        name.set("MIT License")
                        url.set("https://opensource.org/license/mit")
                    }
                }

                developers {
                    developer {
                        name.set("William Callahan")
                        email.set("william@williamcallahan.com")
                        url.set("https://williamcallahan.com")
                    }
                    developer {
                        name.set("Lukasz Grabski")
                        email.set("activey@doaplatform.org")
                    }
                }

                scm {
                    url.set("https://github.com/WilliamAGH/tui4j")
                    connection.set("scm:git:git://github.com/WilliamAGH/tui4j.git")
                    developerConnection.set("scm:git:ssh://git@github.com/WilliamAGH/tui4j.git")
                }
            }
        }
    }

    repositories {
        maven {
            val releasesUrl = uri("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
            val snapshotsUrl = uri("https://s01.oss.sonatype.org/content/repositories/snapshots/")
            url = if (version.toString().endsWith("SNAPSHOT")) snapshotsUrl else releasesUrl

            credentials {
                username = providers.environmentVariable("SONATYPE_USERNAME").orNull
                password = providers.environmentVariable("SONATYPE_PASSWORD").orNull
            }
        }
    }
}

signing {
    val signingKey = providers.environmentVariable("GPG_PRIVATE_KEY").orNull
    val signingPassword = providers.environmentVariable("GPG_PASSPHRASE").orNull

    if (signingKey != null && signingPassword != null) {
        useInMemoryPgpKeys(signingKey, signingPassword)
        sign(publishing.publications)
    }
}

nmcp {
    publishAllPublicationsToCentralPortal {
        username.set(providers.environmentVariable("SONATYPE_USERNAME").orNull)
        password.set(providers.environmentVariable("SONATYPE_PASSWORD").orNull)
        publishingType.set("USER_MANAGED")
    }
}
