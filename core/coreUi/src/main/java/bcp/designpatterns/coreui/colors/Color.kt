package bcp.designpatterns.coreui.colors

import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

/**   Project property of BCP
 *   Created by Dazzord.
 */

val primary = Color(0xFF11141B)
val secondary = Color(0xFF00FABE)
val secondaryLight = Color(0xFF144844)
val secondaryText = Color(0xFFEAF2FF)
val background = Color(0xFF11141B)
val white = Color(0xFFFFFFFF)
val lightBlack = Color(0xFF191C26)
val lightThinBlack = Color(0xFF292C38)
val buttonDisableTextColor = Color(0xFF9C9C9C)
val buttonDisableBackgroundColor = Color(0xFFB7B7B7)

val LightColors = lightColors(
    primary = primary,
    primaryVariant = primary,
    secondary = primary,
    background = background,
    onSurface = background,
    secondaryVariant = background
)

val DarkColors = darkColors(
    primary = primary,
    primaryVariant = primary,
    secondary = primary,
    background = background,
    onSurface = background,
    secondaryVariant = background
)