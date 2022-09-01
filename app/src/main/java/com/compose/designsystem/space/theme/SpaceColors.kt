package com.compose.designsystem.space.theme

import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color

@Stable
class SpaceColors(
    neutral_1: Color,
    neutral_2: Color,
    neutral_3: Color,
    neutral_4: Color,
    neutral_5: Color,
    neutral_6: Color,
    neutral_7: Color,
    neutral_8: Color,
    neutral_9: Color,
    neutral_10: Color,
    primary_1: Color,
    primary_2: Color,
    primary_3: Color,
    primary_4: Color,
    primary_5: Color,
    success_1: Color,
    success_2: Color,
    success_3: Color,
    success_4: Color,
    success_5: Color,
    error_1: Color,
    error_2: Color,
    error_3: Color,
    error_4: Color,
    error_5: Color,
    warning_1: Color,
    warning_2: Color,
    warning_3: Color,
    warning_4: Color,
    warning_5: Color,
    shadesBlack: Color,
    shadesWhite: Color,
    isLight: Boolean,
) {
    var neutral_1 by mutableStateOf(neutral_1, structuralEqualityPolicy())
        internal set
    var neutral_2 by mutableStateOf(neutral_2, structuralEqualityPolicy())
        internal set
    var neutral_3 by mutableStateOf(neutral_3, structuralEqualityPolicy())
        internal set
    var neutral_4 by mutableStateOf(neutral_4, structuralEqualityPolicy())
        internal set
    var neutral_5 by mutableStateOf(neutral_5, structuralEqualityPolicy())
        internal set
    var neutral_6 by mutableStateOf(neutral_6, structuralEqualityPolicy())
        internal set
    var neutral_7 by mutableStateOf(neutral_7, structuralEqualityPolicy())
        internal set
    var neutral_8 by mutableStateOf(neutral_8, structuralEqualityPolicy())
        internal set
    var neutral_9 by mutableStateOf(neutral_9, structuralEqualityPolicy())
        internal set
    var neutral_10 by mutableStateOf(neutral_10, structuralEqualityPolicy())
        internal set

    var primary_1 by mutableStateOf(primary_1, structuralEqualityPolicy())
        internal set
    var primary_2 by mutableStateOf(primary_2, structuralEqualityPolicy())
        internal set
    var primary_3 by mutableStateOf(primary_3, structuralEqualityPolicy())
        internal set
    var primary_4 by mutableStateOf(primary_4, structuralEqualityPolicy())
        internal set
    var primary_5 by mutableStateOf(primary_5, structuralEqualityPolicy())
        internal set

    var success_1 by mutableStateOf(success_1, structuralEqualityPolicy())
        internal set
    var success_2 by mutableStateOf(success_2, structuralEqualityPolicy())
        internal set
    var success_3 by mutableStateOf(success_3, structuralEqualityPolicy())
        internal set
    var success_4 by mutableStateOf(success_4, structuralEqualityPolicy())
        internal set
    var success_5 by mutableStateOf(success_5, structuralEqualityPolicy())
        internal set

    var error_1 by mutableStateOf(error_1, structuralEqualityPolicy())
        internal set
    var error_2 by mutableStateOf(error_2, structuralEqualityPolicy())
        internal set
    var error_3 by mutableStateOf(error_3, structuralEqualityPolicy())
        internal set
    var error_4 by mutableStateOf(error_4, structuralEqualityPolicy())
        internal set
    var error_5 by mutableStateOf(error_5, structuralEqualityPolicy())
        internal set

    var warning_1 by mutableStateOf(warning_1, structuralEqualityPolicy())
        internal set
    var warning_2 by mutableStateOf(warning_2, structuralEqualityPolicy())
        internal set
    var warning_3 by mutableStateOf(warning_3, structuralEqualityPolicy())
        internal set
    var warning_4 by mutableStateOf(warning_4, structuralEqualityPolicy())
        internal set
    var warning_5 by mutableStateOf(warning_5, structuralEqualityPolicy())
        internal set

    var shadesBlack by mutableStateOf(shadesBlack, structuralEqualityPolicy())
        internal set
    var shadesWhite by mutableStateOf(shadesWhite, structuralEqualityPolicy())
        internal set

    var isLight by mutableStateOf(isLight, structuralEqualityPolicy())
        internal set

    fun copy(
        neutral_1: Color = this.neutral_1,
        neutral_2: Color = this.neutral_2,
        neutral_3: Color = this.neutral_3,
        neutral_4: Color = this.neutral_4,
        neutral_5: Color = this.neutral_5,
        neutral_6: Color = this.neutral_6,
        neutral_7: Color = this.neutral_7,
        neutral_8: Color = this.neutral_8,
        neutral_9: Color = this.neutral_9,
        neutral_10: Color = this.neutral_10,
        primary_1: Color = this.primary_1,
        primary_2: Color = this.primary_2,
        primary_3: Color = this.primary_3,
        primary_4: Color = this.primary_4,
        primary_5: Color = this.primary_5,
        success_1: Color = this.success_1,
        success_2: Color = this.success_2,
        success_3: Color = this.success_3,
        success_4: Color = this.success_4,
        success_5: Color = this.success_5,
        error_1: Color = this.error_1,
        error_2: Color = this.error_2,
        error_3: Color = this.error_3,
        error_4: Color = this.error_4,
        error_5: Color = this.error_5,
        warning_1: Color = this.warning_1,
        warning_2: Color = this.warning_2,
        warning_3: Color = this.warning_3,
        warning_4: Color = this.warning_4,
        warning_5: Color = this.warning_5,
        shadesBlack: Color = this.shadesBlack,
        shadesWhite: Color = this.shadesWhite,
        isLight: Boolean = this.isLight,
    ): SpaceColors = SpaceColors(
        neutral_1, neutral_2, neutral_3, neutral_4, neutral_5, neutral_6, neutral_7, neutral_8, neutral_9, neutral_10, primary_1, primary_2, primary_3, primary_4, primary_5, success_1, success_2, success_3, success_4, success_5, error_1, error_2, error_3, error_4, error_5, warning_1, warning_2, warning_3, warning_4, warning_5, shadesBlack, shadesWhite, isLight
    )
}



fun lightSpaceColors(
    neutral_1: Color = Color(0xFFF2F2F2),
    neutral_2: Color = Color(0xFFE5E5E5),
    neutral_3: Color = Color(0xFFCCCCCC),
    neutral_4: Color = Color(0xFFB2B2B2),
    neutral_5: Color = Color(0xFF999999),
    neutral_6: Color = Color(0xFF808080),
    neutral_7: Color = Color(0xFF666666),
    neutral_8: Color = Color(0xFF4D4D4D),
    neutral_9: Color = Color(0xFF333333),
    neutral_10: Color = Color(0xFF1A1A1A),
    primary_1: Color = Color(0xFFEBEBFA),
    primary_2: Color = Color(0xFFADADEB),
    primary_3: Color = Color(0xFF7070DB),
    primary_4: Color = Color(0xFF3333CC),
    primary_5: Color = Color(0xFF24248F),
    success_1: Color = Color(0xFFEBFAF2),
    success_2: Color = Color(0xFFADEBCA),
    success_3: Color = Color(0xFF70DBA2),
    success_4: Color = Color(0xFF33CC79),
    success_5: Color = Color(0xFF248F56),
    error_1: Color = Color(0xFFFBE9EB),
    error_2: Color = Color(0xFFF3BFC3),
    error_3: Color = Color(0xFFEB939B),
    error_4: Color = Color(0xFFDF535F),
    error_5: Color = Color(0xFFC12432),
    warning_1: Color = Color(0xFFFEFCE7),
    warning_2: Color = Color(0xFFFBF5B7),
    warning_3: Color = Color(0xFFF8EE87),
    warning_4: Color = Color(0xFFF3E43F),
    warning_5: Color = Color(0xFFD8C70D),
    shadesBlack: Color = Color.Black,
    shadesWhite: Color = Color.White,
    isLight: Boolean = true,
): SpaceColors = SpaceColors(neutral_1, neutral_2, neutral_3, neutral_4, neutral_5, neutral_6, neutral_7, neutral_8, neutral_9, neutral_10, primary_1, primary_2, primary_3, primary_4, primary_5, success_1, success_2, success_3, success_4, success_5, error_1, error_2, error_3, error_4, error_5, warning_1, warning_2, warning_3, warning_4, warning_5, shadesBlack, shadesWhite, isLight)

fun darkSpaceColors() = lightSpaceColors(isLight = false)

internal val LocalColors = staticCompositionLocalOf { lightSpaceColors() }

internal val LocalContentColor = compositionLocalOf { Color.Black }

internal val LocalContentAlpha = compositionLocalOf { 1f }