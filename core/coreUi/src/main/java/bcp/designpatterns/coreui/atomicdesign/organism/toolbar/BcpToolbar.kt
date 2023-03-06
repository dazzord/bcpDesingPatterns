package bcp.designpatterns.coreui.atomicdesign.organism.toolbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import bcp.designpatterns.coreui.atomicdesign.molecules.lineardoubletitle.bcpLinearDoubleTextView

/**   Project property of BCP
 *   Created by Dazzord.
 */

@Composable
fun bcpToolbar(
    bcpToolbarParams: BcpToolbarParams
) {
    with(bcpToolbarParams) {
        Box(
            contentAlignment = Alignment.TopCenter,
            modifier = Modifier
                .fillMaxWidth()
                .background(color = backgroundColor)
                .padding(top = contentPaddingTop, bottom = contentPaddingBottom)
        ) {
            bcpLinearDoubleTextView(doubleTitleParams)
        }
    }
}