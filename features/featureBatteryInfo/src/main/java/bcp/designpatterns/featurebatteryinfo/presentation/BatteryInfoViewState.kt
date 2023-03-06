package bcp.designpatterns.featurebatteryinfo.presentation

import bcp.designpatterns.featurebatteryinfo.presentation.mapper.BatteryInfoPresentationModel

/**   Project property of BCP
 *   Created by Dazzord.
 */

data class BatteryInfoViewState(
    var isLoading: Boolean = false,
    var batteryInfoList: List<BatteryInfoPresentationModel> = emptyList()
) {

    fun isLoading() = copy(isLoading = true)

    fun batteryInfoReady(batteryInfo: List<BatteryInfoPresentationModel>) = copy(
        batteryInfoList = batteryInfo,
        isLoading = false
    )
}