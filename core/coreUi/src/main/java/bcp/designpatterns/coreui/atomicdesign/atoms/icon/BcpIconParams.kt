package bcp.designpatterns.coreui.atomicdesign.atoms.icon

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import bcp.designpatterns.coreui.R
import bcp.designpatterns.coreui.colors.white

/**   Project property of BCP
 *   Created by Dazzord.
 */

data class BcpIconParams(
    val resourceId: Int = R.drawable.ic_battery,
    val tintColor: Color = white,
    val iconSize: Dp = 30.dp,
    val iconBottomPadding: Dp = 0.dp
)