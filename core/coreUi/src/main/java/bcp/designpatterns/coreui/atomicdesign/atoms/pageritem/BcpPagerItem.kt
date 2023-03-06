package bcp.designpatterns.coreui.atomicdesign.atoms.pageritem

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Tab
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import bcp.designpatterns.coreui.atomicdesign.atoms.icon.bcpIcon
import bcp.designpatterns.coreui.atomicdesign.atoms.textView.bcpTextView
import com.google.accompanist.pager.ExperimentalPagerApi
import kotlinx.coroutines.launch

/**   Project property of BCP
 *   Created by Dazzord.
 */

class BcpPagerItem(
    var bcpPagerItemParams: BcpPagerItemParams,
    val pagerItemContent: @Composable () -> Unit
) {
    /**
     * Bcp pager item tab with icon and title
     * vertically aligned
     *
     */
    @OptIn(ExperimentalPagerApi::class)
    @Composable
    fun bcpPagerItem() {
        with(bcpPagerItemParams) {
            Tab(
                icon = {
                    bcpIcon(bcpIconParams = iconParams)
                },
                text = {
                    Spacer(modifier = Modifier.height(titleIconSpacer))
                    bcpTextView(bcpTextViewParams = titleParams)
                },
                selected = pagerState?.currentPage == position,
                onClick = {
                    coroutineScope?.launch {
                        pagerState?.scrollToPage(position)
                    }
                }
            )
        }
    }

    /**
     * Bcp pager item content
     *
     */
    @Composable
    fun bcpPagerItemContent() {
        pagerItemContent()
    }
}
