package bcp.designpatterns.featuresysteminfo.presentation

import bcp.designpatterns.core.extentions.DoNothing
import bcp.designpatterns.core.usecase.UseCaseExecutorProvider
import bcp.designpatterns.core.viewmodel.BaseViewModel
import bcp.designpatterns.featuresysteminfo.domain.GetSystemInfoUseCase
import bcp.designpatterns.featuresysteminfo.domain.entity.SystemInfoEntity
import bcp.designpatterns.featuresysteminfo.presentation.mapper.SystemInfoEntityToPresentationMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**   Project property of BCP
 *   Created by Dazzord.
 */

@HiltViewModel
class SystemInfoViewModel @Inject constructor(
    private val systemInfoUseCase: GetSystemInfoUseCase,
    private val systemInfoEntityToPresentationMapper: SystemInfoEntityToPresentationMapper,
    useCaseExecutorProvider: UseCaseExecutorProvider
) : BaseViewModel<SystemInfoViewState, Nothing>(useCaseExecutorProvider) {

    init {
        fetchSystemInfo()
    }

    override fun initialState(): SystemInfoViewState = SystemInfoViewState()

    private fun fetchSystemInfo() {
        execute(systemInfoUseCase, DoNothing, ::notifySystemInfoData)
    }

    private fun notifySystemInfoData(systemInfoList: List<SystemInfoEntity>) {
        val systemInfoResult = systemInfoEntityToPresentationMapper.mapperTo(systemInfoList)
        updateViewState { systemInfoReady(systemInfoResult) }
    }
}