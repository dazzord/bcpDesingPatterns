package bcp.designpatterns.featurebatteryinfo.presentation

import bcp.designpatterns.core.extentions.DoNothing
import bcp.designpatterns.core.usecase.UseCaseExecutorProvider
import bcp.designpatterns.core.viewmodel.BaseViewModel
import bcp.designpatterns.featurebatteryinfo.di.BatteryInfoUseCase
import bcp.designpatterns.featurebatteryinfo.di.FakeBatteryInfoUseCase
import bcp.designpatterns.featurebatteryinfo.domain.GetBatteryInfoUseCase
import bcp.designpatterns.featurebatteryinfo.domain.entity.BatteryInfoEntity
import bcp.designpatterns.featurebatteryinfo.presentation.mapper.BatteryInfoEntityListToPresentationMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**   Project property of BCP
 *   Created by Dazzord.
 */

@HiltViewModel
class BatteryInfoViewModel @Inject constructor(
    @FakeBatteryInfoUseCase private val batteryInfoUseCase: GetBatteryInfoUseCase,
    private val batteryInfoEntityListToPresentationMapper: BatteryInfoEntityListToPresentationMapper,
    useCaseExecutorProvider: UseCaseExecutorProvider
) : BaseViewModel<BatteryInfoViewState, Nothing>(useCaseExecutorProvider) {

    init {
        fetchBatteryInfo()
    }

    override fun initialState(): BatteryInfoViewState = BatteryInfoViewState()

    private fun fetchBatteryInfo() {
        execute(batteryInfoUseCase, DoNothing, ::notifyBatteryInfoData)
    }

    private fun notifyBatteryInfoData(batteryInfoList: List<BatteryInfoEntity>) {
        val batteryInfoModel = batteryInfoEntityListToPresentationMapper.mapperTo(batteryInfoList)
        updateViewState { batteryInfoReady(batteryInfoModel) }
    }
}