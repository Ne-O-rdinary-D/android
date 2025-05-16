import com.example.composebaseproject.configureCoroutineAndroid
import com.example.composebaseproject.configureHiltAndroid
import com.example.composebaseproject.configureJUnitAndroid
import com.example.composebaseproject.configureKotlinAndroid

plugins {
    id("com.android.library")
    id("composebaseproject.verify.detekt")
}

configureKotlinAndroid()
configureCoroutineAndroid()
configureHiltAndroid()
configureJUnitAndroid()