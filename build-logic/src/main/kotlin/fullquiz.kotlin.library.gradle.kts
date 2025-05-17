import com.hiearth.fullquiz.configureKotlin
import org.gradle.kotlin.dsl.kotlin

plugins {
    kotlin("jvm")
    id("fullquiz.verify.detekt")
}

configureKotlin()