plugins {
	java
	id("org.springframework.boot") version "3.1.5"
	id("io.spring.dependency-management") version "1.1.3"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_21
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.thymeleaf.extras:thymeleaf-extras-springsecurity6")
	compileOnly("org.projectlombok:lombok")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	//runtimeOnly("org.postgresql:postgresql")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.security:spring-security-test")
	
	// Added dependencies by my self.
	// https://mvnrepository.com/artifact/org.mybatis.spring.boot/mybatis-spring-boot-starter
	implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:3.0.2")
	// https://mvnrepository.com/artifact/org.mybatis/mybatis
	implementation("org.mybatis:mybatis:3.5.13")
	// https://mvnrepository.com/artifact/org.mybatis.generator/mybatis-generator-core
	implementation("org.mybatis.generator:mybatis-generator-core:1.4.2")
	// https://mvnrepository.com/artifact/org.postgresql/postgresql
	runtimeOnly("org.postgresql:postgresql:42.6.0")
	
	
}

tasks.withType<Test> {
	useJUnitPlatform()
}
