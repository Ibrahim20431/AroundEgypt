package com.example.aroundegypt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.aroundegypt.features.homeScreen.HomeScreen
import com.example.aroundegypt.ui.theme.AroundEgyptTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AroundEgyptTheme {
                HomeScreen()
            }
        }
    }
}
