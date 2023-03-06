package bcp.designpatterns.featurebatteryinfo.domain

import bcp.designpatterns.core.coroutine.CoroutineContextProvider
import bcp.designpatterns.core.usecase.BackgroundExecutingUseCase
import bcp.designpatterns.featurebatteryinfo.di.FakeBatteryInfoRepository
import bcp.designpatterns.featurebatteryinfo.domain.entity.BatteryInfoEntity
import bcp.designpatterns.featurebatteryinfo.domain.repository.BatteryInfoRepository

/**   Project property of BCP
 *   Created by Dazzord.
 */
class GetBatteryInfoUseCase(
     private val batteryInfoRepository: BatteryInfoRepository,
    coroutineContextProvider: CoroutineContextProvider
) : BackgroundExecutingUseCase<Unit, List<BatteryInfoEntity>>(coroutineContextProvider) {

    override fun executeInBackground(request: Unit): List<BatteryInfoEntity> =
        batteryInfoRepository.getBatteryInfo()
}