package bcp.designpatterns.coreui.atomicdesign.molecules.icontext

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import bcp.designpatterns.coreui.atomicdesign.atoms.icon.BcpIconParams
import bcp.designpatterns.coreui.atomicdesign.atoms.textView.BcpTextViewParams

/**   Project property of BCP
 *   Created by Dazzord.
 */

data class BcpIconTextViewParams(
    var iconParams: BcpIconParams,
    var textViewParams: BcpTextViewParams,
    var iconTextSpacer: Dp = 22.dp
)
