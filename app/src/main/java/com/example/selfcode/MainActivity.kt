package com.example.selfcode

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.selfcode.model.QuoteViewModel
import com.example.selfcode.screen.QuotesScreen
import com.example.selfcode.ui.theme.SelfCodeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SelfCodeTheme {

                QuotesScreen(viewModel = QuoteViewModel())

            }
        }
    }
}