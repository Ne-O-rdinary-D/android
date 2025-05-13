import com.example.composebaseproject.configureJUnitAndroid
import com.example.composebaseproject.configureKotlin
import org.gradle.kotlin.dsl.kotlin

plugins {
    kotlin("jvm")
    id("composebaseproject.verify.detekt")
}

configureKotlin()
configureJUnitAndroid()