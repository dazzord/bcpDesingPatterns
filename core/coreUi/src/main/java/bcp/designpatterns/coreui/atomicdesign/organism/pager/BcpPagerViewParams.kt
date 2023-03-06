package bcp.designpatterns.coreui.atomicdesign.organism.pager

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import bcp.designpatterns.coreui.atomicdesign.atoms.pageritem.BcpPagerItem
import bcp.designpatterns.coreui.colors.primary
import bcp.designpatterns.coreui.colors.secondary
import bcp.designpatterns.coreui.colors.white

/**   Project property of BCP
 *   Created by Dazzord.
 */

data class BcpPagerViewParams(
    val list: List<BcpPagerItem>,
    val backgroundColor: Color = primary,
    val contentColor: Color = white,
    val tabRowsHeight: Dp = 3.dp,
    val tabRowsColor: Color = secondary,
    val tabSelectedColor: Color = secondary,
    val tabUnselectedColor: Color = white,
    val spacerTopHeight: Dp = 30.dp
)
