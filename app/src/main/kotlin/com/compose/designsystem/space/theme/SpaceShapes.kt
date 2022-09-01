package com.compose.designsystem.space.theme

import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.dp

class SpaceShapes(
    val small: CornerBasedShape = RoundedCornerShape(8.dp),
    val large: CornerBasedShape = RoundedCornerShape(45.dp)
) {

    fun copy(
        small: CornerBasedShape = this.small,
        large: CornerBasedShape = this.large
    ): SpaceShapes = SpaceShapes(
        small = small,
        large = large,
    )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is SpaceShapes) return false
        if (small != other.small) return false
        if (large != other.large) return false
        return true
    }

    override fun hashCode(): Int {
        var result = small.hashCode()
        result = 31 * result + large.hashCode()
        return result
    }

    override fun toString(): String {
        return "Space shapes(small=$small, large=$large)"
    }
}

internal val LocalShapes = staticCompositionLocalOf { SpaceShapes() }