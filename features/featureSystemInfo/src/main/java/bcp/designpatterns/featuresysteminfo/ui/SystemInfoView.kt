package bcp.designpatterns.featuresysteminfo.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import bcp.designpatterns.coreui.atomicdesign.atoms.divider.BcpDividerParams
import bcp.designpatterns.coreui.atomicdesign.atoms.textView.BcpTextViewParams
import bcp.designpatterns.coreui.atomicdesign.molecules.titlesubtitle.BcpTitleSubtitleTextViewParams
import bcp.designpatterns.coreui.atomicdesign.molecules.titlesubtitle.bcpTitleSubtitleTextView
import bcp.designpatterns.coreui.colors.lightBlack
import bcp.designpatterns.featuresysteminfo.presentation.SystemInfoViewModel

/**   Project property of BCP
 *   Created by Dazzord.
 */

@Composable
fun systemInfoView(
    systemInfoViewModel: SystemInfoViewModel = hiltViewModel()
) {
    val systemInfoDataList = systemInfoViewModel.viewState.collectAsState()

    Scaffold {
        LazyColumn(
            modifier = Modifier
                .padding(it)
                .background(color = lightBlack)
        ) {
            itemsIndexed(
                items = systemInfoDataList.value.systemInfoList
            ) { _, item ->
                secondTabItem(titleValue = item.type, subtitle = item.value)
            }
        }
    }

}

@Composable
fun secondTabItem(titleValue: String, subtitle: String) {

    Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 20.dp)) {
        bcpTitleSubtitleTextView(
            bcpTitleSubtitleTextViewParams = BcpTitleSubtitleTextViewParams(
                titleParams = BcpTextViewParams(title = titleValue),
                subtitleParams = BcpTextViewParams(title = subtitle),
                dividerParams = BcpDividerParams()
            )
        )
    }
}