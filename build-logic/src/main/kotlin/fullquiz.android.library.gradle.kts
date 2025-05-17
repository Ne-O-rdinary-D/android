import com.hiearth.fullquiz.configureCoroutineAndroid
import com.hiearth.fullquiz.configureHiltAndroid
import com.hiearth.fullquiz.configureJUnitAndroid
import com.hiearth.fullquiz.configureKotlinAndroid

plugins {
    id("com.android.library")
    id("fullquiz.verify.detekt")
}

configureKotlinAndroid()
configureCoroutineAndroid()
configureHiltAndroid()
configureJUnitAndroid()