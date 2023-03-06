package bcp.designpatterns.coreui.atomicdesign.organism.pager

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState

/**   Project property of BCP
 *   Created by Dazzord.
 */

@OptIn(ExperimentalPagerApi::class)
@Composable
fun bcpPagerView(
    bcpPagerViewParams: BcpPagerViewParams
) {
    with(bcpPagerViewParams) {

        val pagerState = rememberPagerState()
        Spacer(modifier = Modifier.height(spacerTopHeight))
        Tabs(pagerState = pagerState, bcpPagerViewParams = this)
        TabsContent(pagerState = pagerState, bcpPagerViewParams = this)
    }
}

@OptIn(ExperimentalPagerApi::class)
private fun selectedColor(
    bcpPagerViewParams: BcpPagerViewParams,
    pagerState: PagerState,
    index: Int
) =
    if (pagerState.currentPage == index) bcpPagerViewParams.tabSelectedColor else bcpPagerViewParams.tabUnselectedColor

@OptIn(ExperimentalPagerApi::class)
@Composable
private fun Tabs(bcpPagerViewParams: BcpPagerViewParams, pagerState: PagerState) {
    val scope = rememberCoroutineScope()
    with(bcpPagerViewParams) {
        TabRow(
            selectedTabIndex = pagerState.currentPage,
            backgroundColor = backgroundColor,
            contentColor = contentColor,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    Modifier.tabIndicatorOffset(tabPositions[pagerState.currentPage]),
                    height = tabRowsHeight,
                    color = tabRowsColor
                )
            }
        ) {
            list.forEachIndexed { index, _ ->
                with(this.list[index]) {
                    bcpPagerItemParams = bcpPagerItemParams.copy(
                        iconParams = bcpPagerItemParams.iconParams.copy(
                            tintColor = selectedColor(bcpPagerViewParams, pagerState, index),
                            iconBottomPadding = 12.dp
                        ),
                        position = index,
                        pagerState = pagerState,
                        coroutineScope = scope
                    )
                    bcpPagerItem()
                }
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
private fun TabsContent(bcpPagerViewParams: BcpPagerViewParams, pagerState: PagerState) {

    HorizontalPager(
        state = pagerState,
        contentPadding = PaddingValues(0.dp),
        count = bcpPagerViewParams.list.size
    ) { page ->
        //tabs content here
        bcpPagerViewParams.list[page].pagerItemContent.invoke()
    }
}
