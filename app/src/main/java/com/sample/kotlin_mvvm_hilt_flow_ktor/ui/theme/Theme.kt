package com.sample.kotlin_mvvm_hilt_flow_ktor.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable


/**
 * @author Ashik
 * Created on 21/10/21 .
 */

@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColor
    } else {
        LightColor
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}

private val DarkColor = darkColors(
    primary = color1,
    primaryVariant = color3,
    secondary = color4
)

private val LightColor = lightColors(
    primary = color2,
    primaryVariant = color3,
    secondary = color4
)

