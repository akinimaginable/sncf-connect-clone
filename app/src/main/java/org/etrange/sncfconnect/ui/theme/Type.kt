package org.etrange.sncfconnect.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.etrange.sncfconnect.R

val Avenir = FontFamily(
    Font(R.font.avenir_medium, FontWeight.Medium), Font(R.font.avenir_heavy, FontWeight.Bold)
)

val Achemine = FontFamily(
    Font(R.font.achemine, FontWeight.Normal), Font(R.font.achemine_bold, FontWeight.Bold)
)

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ), headlineLarge = TextStyle(
        fontFamily = Achemine,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
        lineHeight = 32.sp,
        letterSpacing = 0.2.sp
    ), headlineMedium = TextStyle(
        fontFamily = Avenir,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        lineHeight = 32.sp,
        letterSpacing = 0.3.sp
    ), titleLarge = TextStyle(
        fontFamily = Avenir,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp,
        lineHeight = 32.sp,
        letterSpacing = 0.2.sp
    ), titleSmall = TextStyle(
        fontFamily = Avenir,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.2.sp
    ),
    labelMedium = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal
    )
)
