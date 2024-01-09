package com.wonder.wonderui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Dimensions(
    val small: Dp = 4.dp,
    val medium: Dp = 8.dp,
    val large: Dp = 24.dp
)

internal val LocalDimensions = staticCompositionLocalOf { Dimensions() }