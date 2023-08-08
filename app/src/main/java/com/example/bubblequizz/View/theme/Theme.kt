package com.example.bubblequizz.View.theme

import android.app.Activity
import android.hardware.lights.Light
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.example.bubblequizz.View.theme.Heading1
import com.example.bubblequizz.View.theme.Heading2
import com.example.bubblequizz.View.theme.Heading3
import com.example.bubblequizz.View.theme.Heading4



/*https://developer.android.com/jetpack/compose/designsystems/custom?hl=fr#replacing-systems*/
@Immutable
data class CustomColors(
    val PrimaryColor : Color,
    val DarkColor : Color,
    val GreyMidColor : Color,
    val GreyLightColor : Color,
    val LightColor : Color,
    val RedColor : Color
)

@Immutable
data class CustomTypography(
    val Heading1: TextStyle,
    val Heading2: TextStyle,
    val Heading3: TextStyle,
    val Heading4: TextStyle
)

val LocalCustomColors = staticCompositionLocalOf {
    CustomColors(
        PrimaryColor = Color.Unspecified,
        DarkColor = Color.Unspecified,
        GreyMidColor = Color.Unspecified,
        GreyLightColor = Color.Unspecified,
        LightColor = Color.Unspecified,
        RedColor = Color.Unspecified,
    )
}
val LocalCustomTypography = staticCompositionLocalOf {
    CustomTypography(
        Heading1 = TextStyle.Default,
        Heading2 = TextStyle.Default,
        Heading3 = TextStyle.Default,
        Heading4 = TextStyle.Default
    )
}

@Composable
fun CustomTheme(
    /* ... */
    content: @Composable () -> Unit
) {
    val customColors = CustomColors(
        PrimaryColor = Color(0x5136D9),
        DarkColor = Color(0x302840),
        GreyMidColor = Color(0x777380),
        GreyLightColor = Color(0xF6F6F6),
        LightColor = Color(0xF2EEFA),
        RedColor = Color(0xD93636),
    )
    val customTypography = CustomTypography(
        Heading1 = Heading1,
        Heading2 = Heading2,
        Heading3 = Heading3,
        Heading4 = Heading4
    )
    CompositionLocalProvider(
        LocalCustomColors provides customColors,
        LocalCustomTypography provides customTypography,
        content = content
    )
}

// Use with eg. CustomTheme.elevation.small
object CustomTheme {
    val colors: CustomColors
        @Composable
        get() = LocalCustomColors.current
    val typography: CustomTypography
        @Composable
        get() = LocalCustomTypography.current
}



/*FIGMA Colors
val PrimaryColor = Color(0x5136D9)
val DarkColor = Color(0x302840)
val GreyMidColor = Color(0x777380)
val GreyLightColor = Color(0xF6F6F6)
val LightColor = Color(0xF2EEFA)
val RedColor = Color(0xD93636)
*/



/*
private val DarkColorScheme = (
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
);

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

val background = Color(0xFFFFFBFE)
val surface = Color(0xFFFFFBFE)
val onPrimary = Color.White
val onSecondary = Color.White
val onTertiary = Color.White
val onBackground = Color(0xFF1C1B1F)
val onSurface = Color(0xFF1C1B1F)
*/

/* J'ai commenté le thème pour l'instant parce qu'en fait on à tout fait en light et juste pour faire marcher pour l'instant mais faudra fixer ça*/
/*@Composable
fun BubbleQuizzTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}*/