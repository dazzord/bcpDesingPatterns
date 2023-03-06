package bcp.designpatterns.coreui.atomicdesign.molecules.titlesubtitle

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import bcp.designpatterns.coreui.atomicdesign.atoms.divider.bcpDividerView
import bcp.designpatterns.coreui.atomicdesign.atoms.textView.bcpTextView

/**   Project property of BCP
 *   Created by Dazzord.
 */

@Composable
fun bcpTitleSubtitleTextView(
    bcpTitleSubtitleTextViewParams: BcpTitleSubtitleTextViewParams
) {
    with(bcpTitleSubtitleTextViewParams) {
        bcpTextView(titleParams)
        Spacer(modifier = Modifier.height(titleSpacer))
        bcpTextView(subtitleParams)
        Spacer(modifier = Modifier.height(subtitleSpacer))
        bcpDividerView(bcpDividerParams = dividerParams)
    }
}