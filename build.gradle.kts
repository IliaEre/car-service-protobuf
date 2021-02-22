import Build_gradle.Directory.generateDirectory
import Build_gradle.Directory.sourceDirectory
import com.google.protobuf.gradle.protobuf
import com.google.protobuf.gradle.protoc
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

object Directory {
	const val sourceDirectory = "src/main/resources/protobuf"
	const val generateDirectory = "src"
}

plugins {
	id("org.springframework.boot") version "2.4.3"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm") version "1.4.30"
	kotlin("plugin.spring") version "1.4.30"
	id("com.google.protobuf") version "0.8.8"
	id("com.google.cloud.tools.jib") version "2.7.1"
//	id("org.jlleitschuh.gradle.ktlint") version "10.0.0"
}

group = "com.ere.service"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_15

repositories {
	mavenCentral()
}

sourceSets {
	protobuf {
		generatedFilesBaseDir = generateDirectory
	}
}

extra["springCloudVersion"] = "2020.0.1"

dependencies {
	// main
	implementation("org.springframework.boot:spring-boot-starter-webflux")
	//	implementation("org.springframework.cloud:spring-cloud-stream")
	// kotlin
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
	// db
	implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
	runtimeOnly("com.h2database:h2")
	runtimeOnly("io.r2dbc:r2dbc-h2")
	// endpoint
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	// protobuf
	implementation("com.google.protobuf:protobuf-java:4.0.0-rc-2")
	protobuf(files(sourceDirectory))
 	// tests
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("io.projectreactor:reactor-test")
}

dependencyManagement {
	imports {
		mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
	}
}

protobuf {
	protoc {
		artifact = "com.google.protobuf:protoc:3.0.0"
	}
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "15"
	}
	dependsOn(":generateProto")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

jib {
	to {
		tags = setOf("${project.version}", "latest")
	}
	container {
		jvmFlags = listOf("-Xms256m", "-Xmx512m")
	}
}
