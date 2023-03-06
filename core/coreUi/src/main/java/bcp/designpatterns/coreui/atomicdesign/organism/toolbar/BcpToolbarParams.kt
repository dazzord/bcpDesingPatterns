package bcp.designpatterns.coreui.atomicdesign.organism.toolbar

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import bcp.designpatterns.coreui.atomicdesign.molecules.lineardoubletitle.BcpLinearDoubleTextViewParams
import bcp.designpatterns.coreui.colors.primary

/**   Project property of BCP
 *   Created by Dazzord.
 */

data class BcpToolbarParams(
    var doubleTitleParams: BcpLinearDoubleTextViewParams,
    var backgroundColor: Color = primary,
    var contentPaddingTop: Dp = 30.dp,
    var contentPaddingBottom: Dp = 16.dp
)
