import org.gradle.api.credentials.HttpHeaderCredentials
import org.gradle.authentication.http.HttpHeaderAuthentication

plugins {
  kotlin("jvm") version "1.9.10"
  application
  id("pl.andrzejressel.deeplambdaserialization")
}

repositories {
  mavenCentral()
  mavenLocal()
}

repositories {
  maven {
    url = uri("https://maven.pkg.github.com/andrzejressel/simple-java-serialization")
    credentials(HttpHeaderCredentials::class) {
      name = "Authorization"
      value = "Bearer ${project.findProperty("gpr.token")}"
    }
    authentication { create<HttpHeaderAuthentication>("header") }
  }
}

dependencies { implementation("pl.andrzejressel.djcs:lib:DEV") }

application { mainClass.set("com.example.project.MainKt") }