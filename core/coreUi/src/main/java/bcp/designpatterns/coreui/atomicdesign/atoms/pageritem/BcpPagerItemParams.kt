package bcp.designpatterns.coreui.atomicdesign.atoms.pageritem

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import bcp.designpatterns.coreui.atomicdesign.atoms.icon.BcpIconParams
import bcp.designpatterns.coreui.atomicdesign.atoms.textView.BcpTextViewParams
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import kotlinx.coroutines.CoroutineScope

/**   Project property of BCP
 *   Created by Dazzord.
 */

data class BcpPagerItemParams @OptIn(ExperimentalPagerApi::class) constructor(
    var iconParams: BcpIconParams,
    var titleParams: BcpTextViewParams,
    var titleIconSpacer: Dp = 4.dp,
    var pagerState: PagerState? = null,
    var position: Int = 0,
    var coroutineScope: CoroutineScope? = null
)
