package com.example.aroundegypt

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.printToLog
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

//    @Rule
//    @JvmField
//    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun useAppContext() {

//        composeTestRule.onRoot().printToLog("MainActivityCompose")
//        val checkButton = composeTestRule.onNodeWithTag("")
//        composeTestRule.onNodeWithText("Welcome!")
//        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
//        assertEquals("com.example.aroundegypt", appContext.packageName)
    }
}