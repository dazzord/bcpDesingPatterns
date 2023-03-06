package bcp.designpatterns.coreui.atomicdesign.atoms.icon

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource

/**   Project property of BCP
 *   Created by Dazzord.
 */

@Composable
fun bcpIcon(
    bcpIconParams: BcpIconParams
) {
    with(bcpIconParams) {
        Icon(
            painterResource(id = resourceId),
            contentDescription = null,
            tint = tintColor,
            modifier = Modifier
                .size(iconSize)
                .padding(bottom = iconBottomPadding)
        )
    }
}