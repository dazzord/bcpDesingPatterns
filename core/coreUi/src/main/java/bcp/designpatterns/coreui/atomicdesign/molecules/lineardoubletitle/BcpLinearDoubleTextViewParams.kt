package bcp.designpatterns.coreui.atomicdesign.molecules.lineardoubletitle

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import bcp.designpatterns.coreui.atomicdesign.atoms.textView.BcpTextViewParams

/**   Project property of BCP
 *   Created by Dazzord.
 */

data class BcpLinearDoubleTextViewParams(
    var leftTextViewParams: BcpTextViewParams,
    var rightTextViewParams: BcpTextViewParams,
    var spacerBetweenTextSize: Dp = 4.dp
)