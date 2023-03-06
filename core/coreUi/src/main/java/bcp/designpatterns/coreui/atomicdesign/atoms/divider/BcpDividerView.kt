package bcp.designpatterns.coreui.atomicdesign.atoms.divider

import androidx.compose.material.Divider
import androidx.compose.runtime.Composable

/**   Project property of BCP
 *   Created by Dazzord.
 */

@Composable
fun bcpDividerView(
    bcpDividerParams: BcpDividerParams
) {
    with(bcpDividerParams) {
        Divider(thickness = thickness, color = color)
    }
}