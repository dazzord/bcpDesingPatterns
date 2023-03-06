package bcp.designpatterns.featuresysteminfo.presentation

import bcp.designpatterns.featuresysteminfo.presentation.mapper.SystemInfoPresentationModel

/**   Project property of BCP
 *   Created by Dazzord.
 */

data class SystemInfoViewState(
    val isLoading: Boolean = false,
    val systemInfoList: List<SystemInfoPresentationModel> = emptyList()
) {
    fun isLoading() = copy(isLoading = true)

    fun systemInfoReady(systemInfo: List<SystemInfoPresentationModel>) = copy(
        systemInfoList = systemInfo,
        isLoading = false
    )
}