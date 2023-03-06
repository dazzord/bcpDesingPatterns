package bcp.designpatterns.coreui.atomicdesign.molecules.lineardoubletitle

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import bcp.designpatterns.coreui.atomicdesign.atoms.textView.bcpTextView

/**   Project property of BCP
 *   Created by Dazzord.
 */

@Composable
fun bcpLinearDoubleTextView(
    bcpLinearDoubleTextViewParams: BcpLinearDoubleTextViewParams
) {
    with(bcpLinearDoubleTextViewParams) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom
        ) {
            //Left Title
            bcpTextView(bcpTextViewParams = leftTextViewParams)

            Spacer(modifier = Modifier.width(spacerBetweenTextSize))

            //Right Title
            bcpTextView(bcpTextViewParams = rightTextViewParams)
        }
    }
}