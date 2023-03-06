package bcp.designpatterns.featurehome.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import bcp.designpatterns.coreui.atomicdesign.atoms.icon.BcpIconParams
import bcp.designpatterns.coreui.atomicdesign.atoms.icon.builderdesignpattern.BcpIconParamsWithBuilder
import bcp.designpatterns.coreui.atomicdesign.atoms.pageritem.BcpPagerItem
import bcp.designpatterns.coreui.atomicdesign.atoms.pageritem.BcpPagerItemParams
import bcp.designpatterns.coreui.atomicdesign.atoms.textView.BcpTextViewParams
import bcp.designpatterns.coreui.atomicdesign.molecules.lineardoubletitle.BcpLinearDoubleTextViewParams
import bcp.designpatterns.coreui.atomicdesign.organism.pager.BcpPagerViewParams
import bcp.designpatterns.coreui.atomicdesign.organism.pager.bcpPagerView
import bcp.designpatterns.coreui.atomicdesign.organism.toolbar.BcpToolbarParams
import bcp.designpatterns.coreui.atomicdesign.organism.toolbar.bcpToolbar
import bcp.designpatterns.featurebatteryinfo.ui.batteryInfo
import bcp.designpatterns.featurehome.presentation.HomeViewModel
import bcp.designpatterns.featuresysteminfo.ui.systemInfoView

/**   Project property of BCP
 *   Created by Dazzord.
 */
@Composable
fun home(
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val viewState = homeViewModel.viewState.collectAsState()

    Scaffold(
        topBar = {
            bcpToolbar(
                bcpToolbarParams = BcpToolbarParams(
                    doubleTitleParams = BcpLinearDoubleTextViewParams(
                        leftTextViewParams = BcpTextViewParams(title = viewState.value.homeInfo?.toolbarLinearTitle.orEmpty()),
                        rightTextViewParams = BcpTextViewParams(title = viewState.value.homeInfo?.toolbarLinearSubtitle.orEmpty())
                    )
                )
            )
        },
        content = {
            Column(modifier = Modifier.padding(it)) {
                bcpPagerView(
                    bcpPagerViewParams = BcpPagerViewParams(
                        listOf(
                            BcpPagerItem(
                                bcpPagerItemParams = BcpPagerItemParams(
                                    BcpIconParamsWithBuilder.Builder()
                                        .setResourceId(bcp.designpatterns.coreui.R.drawable.ic_battery)
                                        .build(),
                                    BcpTextViewParams(title = stringResource(id = bcp.designpatterns.coreui.R.string.battery))
                                ),
                                pagerItemContent = { batteryInfo() }
                            ),
                            BcpPagerItem(
                                bcpPagerItemParams = BcpPagerItemParams(
                                    BcpIconParams(bcp.designpatterns.coreui.R.drawable.ic_system),
                                    BcpTextViewParams(title = stringResource(id = bcp.designpatterns.coreui.R.string.system))
                                ),
                                pagerItemContent = { systemInfoView() }
                            )
                        )
                    )
                )
            }
        }
    )
}