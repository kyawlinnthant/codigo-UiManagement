package com.kyawlinnthant.codigo.three.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Dimen(
    val small: Dp = 4.dp,
    val base: Dp = 8.dp,
    val standard: Dp = 12.dp,
    val base2x: Dp = 16.dp,
    val icon: Dp = 22.dp,
    val base3x: Dp = 32.dp,
    val button: Dp = 54.dp,
    val topProfile: Dp = 48.dp,
    val base4x: Dp = 64.dp,
    val base5x: Dp = 128.dp,
    val profile: Dp = 36.dp,
    val indicator: Dp = 8.dp,
    val contentSection: Dp = 168.dp,
    val indicatorPadding: Dp = 200.dp
)

val LocalSize = compositionLocalOf { Dimen() }
val MaterialTheme.dimen: Dimen
    @Composable
    @ReadOnlyComposable
    get() = LocalSize.current
