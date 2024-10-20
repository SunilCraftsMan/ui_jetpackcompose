package com.example.jetpackbasicui.utils

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Path
import kotlin.math.abs

fun Path.standardQuadFromTo(from: Offset, to: Offset) {
    // this function is basically draw
    // a line to our second point and
    // also smooth on that line and make it curve
    quadraticTo(
        from.x,
        from.y,
        abs(from.x + to.x) / 2f,
        abs(from.y + to.y) / 2f
    )
}