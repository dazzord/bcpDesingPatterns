package bcp.designpatterns.featurebatteryinfo.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import bcp.designpatterns.coreui.R
import bcp.designpatterns.coreui.atomicdesign.atoms.circularprogressbar.BcpCircularProgressBarParams
import bcp.designpatterns.coreui.atomicdesign.atoms.circularprogressbar.bcpCircularProgressBar
import bcp.designpatterns.coreui.atomicdesign.atoms.icon.BcpIconParams
import bcp.designpatterns.coreui.atomicdesign.atoms.textView.BcpTextViewParams
import bcp.designpatterns.coreui.atomicdesign.atoms.textView.bcpTextView
import bcp.designpatterns.coreui.atomicdesign.molecules.icontext.BcpIconTextViewParams
import bcp.designpatterns.coreui.atomicdesign.molecules.icontext.bcpIconTextView
import bcp.designpatterns.coreui.colors.lightBlack
import bcp.designpatterns.coreui.colors.lightThinBlack
import bcp.designpatterns.featurebatteryinfo.presentation.BatteryInfoViewModel

/**   Project property of BCP
 *   Created by Dazzord.
 */

@Composable
fun batteryInfo(
    batteryInfoViewModel: BatteryInfoViewModel = hiltViewModel()
) {
    val batteryInfo = batteryInfoViewModel.viewState.collectAsState()

    Scaffold {
        LazyColumn(
            modifier = Modifier
                .background(color = lightBlack)
                .padding(it)
        ) {
            itemsIndexed(
                items = batteryInfo.value.batteryInfoList
            ) { _, bat ->
                if (bat.icon == R.drawable.ic_battery) {
                    batteryLevel(
                        progressValue = bat.value.substring(0, bat.value.length - 1).toFloat()
                    )
                } else {
                    batteryInfoItem(resourceId = bat.icon, title = bat.text, value = bat.value)
                }
            }
        }
    }

}

@Composable
fun batteryInfoItem(resourceId: Int, title: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = lightThinBlack),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.6f)
                .background(color = lightBlack),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            bcpIconTextView(
                bcpIconTextViewParams = BcpIconTextViewParams(
                    iconParams = BcpIconParams(resourceId = resourceId),
                    textViewParams = BcpTextViewParams(title = title)
                )
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            bcpTextView(bcpTextViewParams = BcpTextViewParams(title = value))
        }
    }
}

@Composable
fun batteryLevel(progressValue: Float) {
    Spacer(modifier = Modifier.height(20.dp))
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                contentAlignment = Alignment.Center
            ) {
                bcpCircularProgressBar(
                    bcpCircularProgressBarParams = BcpCircularProgressBarParams(
                        progressValue = progressValue / 100
                    )
                )
                bcpTextView(bcpTextViewParams = BcpTextViewParams(title = "${progressValue.toInt()}%"))
            }

        }
    }
    Spacer(modifier = Modifier.height(20.dp))
}
