package bcp.designpatterns.coreui.atomicdesign.molecules.icontext

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import bcp.designpatterns.coreui.atomicdesign.atoms.icon.bcpIcon
import bcp.designpatterns.coreui.atomicdesign.atoms.textView.bcpTextView

/**   Project property of BCP
 *   Created by Dazzord.
 */

@Composable
fun bcpIconTextView(
    bcpIconTextViewParams: BcpIconTextViewParams
) {
    with(bcpIconTextViewParams) {
        Row(
            modifier = Modifier.padding(20.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            bcpIcon(bcpIconParams = iconParams)
            Spacer(modifier = Modifier.width(22.dp))
            bcpTextView(bcpTextViewParams = textViewParams)
        }
    }
}