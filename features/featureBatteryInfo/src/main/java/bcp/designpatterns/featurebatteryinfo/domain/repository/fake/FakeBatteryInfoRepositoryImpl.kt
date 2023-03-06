package bcp.designpatterns.featurebatteryinfo.domain.repository.fake

import bcp.designpatterns.featurebatteryinfo.domain.entity.BatteryInfoEntity
import bcp.designpatterns.featurebatteryinfo.domain.repository.BatteryInfoRepository
import javax.inject.Inject

/**
 * Project property of BCP
 * Created by Dazzord.
 */


class FakeBatteryInfoRepositoryImpl @Inject constructor(): BatteryInfoRepository {

    override fun getBatteryInfo(): List<BatteryInfoEntity> {
       return emptyList()
    }
}