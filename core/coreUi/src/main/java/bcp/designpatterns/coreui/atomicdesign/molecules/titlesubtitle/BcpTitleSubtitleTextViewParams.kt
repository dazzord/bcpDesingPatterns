package bcp.designpatterns.coreui.atomicdesign.molecules.titlesubtitle

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import bcp.designpatterns.coreui.atomicdesign.atoms.divider.BcpDividerParams
import bcp.designpatterns.coreui.atomicdesign.atoms.textView.BcpTextViewParams

/**   Project property of BCP
 *   Created by Dazzord.
 */
data class BcpTitleSubtitleTextViewParams(
    var titleParams: BcpTextViewParams,
    var subtitleParams: BcpTextViewParams,
    var dividerParams: BcpDividerParams,
    var titleSpacer: Dp = 6.dp,
    var subtitleSpacer: Dp = 20.dp
)
