package com.compose.designsystem.space.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.compose.designsystem.R

val PlexSans = FontFamily(
    Font(R.font.plex_sans_regular, FontWeight.Normal),
    Font(R.font.plex_sans_bold, FontWeight.Bold)
)

class SpaceTypography internal constructor(
    val d1: TextStyle,
    val d2: TextStyle,
    val h1: TextStyle,
    val h2: TextStyle,
    val h3: TextStyle,
    val h4: TextStyle,
    val h5: TextStyle,
    val h6: TextStyle,
    val h7: TextStyle,
) {

    constructor(
        defaultFontFamily: FontFamily = PlexSans,
        d1: TextStyle = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 96.sp,
            lineHeight = 120.sp,
        ),
        d2: TextStyle = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 80.sp,
            lineHeight = 104.sp,
        ),
        h1: TextStyle = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 40.sp,
            lineHeight = 56.sp,
        ),
        h2: TextStyle = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            lineHeight = 40.sp,
        ),
        h3: TextStyle = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            lineHeight = 32.sp,
        ),
        h4: TextStyle = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            lineHeight = 24.sp,
        ),
        h5: TextStyle = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            lineHeight = 20.sp,
        ),
        h6: TextStyle = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            lineHeight = 16.sp,
        ),
        h7: TextStyle = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 8.sp,
            lineHeight = 12.sp,
        ),
    ) : this(
        d1.withDefaultFontFamily(defaultFontFamily),
        d2.withDefaultFontFamily(defaultFontFamily),
        h1.withDefaultFontFamily(defaultFontFamily),
        h2.withDefaultFontFamily(defaultFontFamily),
        h3.withDefaultFontFamily(defaultFontFamily),
        h4.withDefaultFontFamily(defaultFontFamily),
        h5.withDefaultFontFamily(defaultFontFamily),
        h6.withDefaultFontFamily(defaultFontFamily),
        h7.withDefaultFontFamily(defaultFontFamily),
    )

    fun copy(
        d1: TextStyle = this.d1,
        d2: TextStyle = this.d2,
        h1: TextStyle = this.h1,
        h2: TextStyle = this.h2,
        h3: TextStyle = this.h3,
        h4: TextStyle = this.h4,
        h5: TextStyle = this.h5,
        h6: TextStyle = this.h6,
        h7: TextStyle = this.h7,
    ): SpaceTypography = SpaceTypography(
        d1, d2, h1, h2, h3, h4, h5, h6, h7
    )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is SpaceTypography) return false

        if (d1 != other.d1) return false
        if (d2 != other.d2) return false
        if (h1 != other.h1) return false
        if (h2 != other.h2) return false
        if (h3 != other.h3) return false
        if (h4 != other.h4) return false
        if (h5 != other.h5) return false
        if (h6 != other.h6) return false
        if (h7 != other.h7) return false

        return true
    }

    override fun hashCode(): Int {
        var result = d1.hashCode()
        result = 31 * result + d2.hashCode()
        result = 31 * result + h1.hashCode()
        result = 31 * result + h2.hashCode()
        result = 31 * result + h3.hashCode()
        result = 31 * result + h4.hashCode()
        result = 31 * result + h5.hashCode()
        result = 31 * result + h6.hashCode()
        result = 31 * result + h7.hashCode()
        return result
    }
}

private fun TextStyle.withDefaultFontFamily(default: FontFamily): TextStyle {
    return if (fontFamily != null) this else copy(fontFamily = default)
}

internal val LocalTypography = staticCompositionLocalOf { SpaceTypography() }