package com.sample.kotlin_mvvm_hilt_flow_ktor.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import com.sample.kotlin_mvvm_hilt_flow_ktor.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {

    @ExperimentalUnitApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme(darkTheme = false) {
                Surface(color = MaterialTheme.colors.background) {
                    Column {
                        Text(
                            text = "Kotlin DSL Sample!",
                            style = TextStyle(fontSize = TextUnit(26f, TextUnitType.Sp))
                        )
                    }
                }
            }
        }
    }
}

