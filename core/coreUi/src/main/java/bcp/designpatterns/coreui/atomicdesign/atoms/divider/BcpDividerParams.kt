package bcp.designpatterns.coreui.atomicdesign.atoms.divider

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import bcp.designpatterns.coreui.colors.secondaryText

/**   Project property of BCP
 *   Created by Dazzord.
 */

data class BcpDividerParams(
    var thickness: Dp = 1.dp,
    var color: Color = secondaryText
)
