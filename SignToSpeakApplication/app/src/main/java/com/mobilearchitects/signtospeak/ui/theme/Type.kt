package com.mobilearchitects.signtospeak.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp
import com.mobilearchitects.signtospeak.R
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle

val nunitoSansFontFamily = FontFamily(
    Font(R.font.nunitosans_black, FontWeight.Black),
    Font(R.font.nunitosans_bold, FontWeight.Bold),
    Font(R.font.nunitosans_light, FontWeight.Light),
    Font(R.font.nunitosans_regular, FontWeight.Normal),
    Font(R.font.nunitosans_medium, FontWeight.Medium),
    Font(R.font.nunitosans_semibold, FontWeight.SemiBold),
    Font(R.font.nunitosans_extralight, FontWeight.ExtraLight),
//    Font(R.font.nunitosans_italic, FontStyle.Italic),
    )


/*cant get this method to work
val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

val fontName = GoogleFont("Rubik")

val fontFamily = FontFamily(
    Font(
        googleFont = fontName,
        fontProvider = provider
    )
) */

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = nunitoSansFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ) ,
    titleLarge = TextStyle(
        fontFamily = nunitoSansFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = nunitoSansFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )

)