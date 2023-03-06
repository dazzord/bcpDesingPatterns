package bcp.designpatterns.coreui.atomicdesign.atoms.textView

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import bcp.designpatterns.coreui.colors.white
import bcp.designpatterns.coreui.typography.typography

/**   Project property of BCP
 *   Created by Dazzord.
 */

data class BcpTextViewParams(
    var title: String = "",
    var titleColor: Color = white,
    var titleStyle: TextStyle = typography.h2,
    var paddingStartEnd: Dp = 0.dp
)