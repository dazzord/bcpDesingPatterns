package bcp.designpatterns.coreui.atomicdesign.atoms.textView

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

/**   Project property of BCP
 *   Created by Dazzord.
 */

@Composable
fun bcpTextView(
    bcpTextViewParams: BcpTextViewParams
) {
    with(bcpTextViewParams) {
        Text(
            text = title,
            color = titleColor,
            style = titleStyle,
            modifier = Modifier.padding(start = paddingStartEnd, end = paddingStartEnd)
        )
    }
}

//Preview
@Preview
@Composable
fun previewSingleTitle() {
    bcpTextView(
        BcpTextViewParams(
            title = "Bcp Design"
        )
    )
}