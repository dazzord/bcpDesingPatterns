package bcp.designpatterns.coreui.theme

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import bcp.designpatterns.coreui.colors.DarkColors
import bcp.designpatterns.coreui.colors.LightColors
import bcp.designpatterns.coreui.colors.background
import bcp.designpatterns.coreui.typography.typography


/**   Project property of Bcp
 *   Created by Dazzord.
 */
@Composable
fun BCPDesignPatternsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = if (darkTheme) DarkColors else LightColors,
        typography = typography
    ) {
        CompositionLocalProvider(
            LocalIndication provides rememberRipple(color = background),
            content = content
        )
    }
}