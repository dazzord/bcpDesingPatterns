package bcp.designpatterns.featurebatteryinfo.data

import bcp.designpatterns.featurebatteryinfo.data.mapper.BatteryInfoModelToBatteryInfoEntityMapper
import bcp.designpatterns.featurebatteryinfo.domain.entity.BatteryInfoEntity
import bcp.designpatterns.featurebatteryinfo.domain.repository.BatteryInfoRepository
import bcp.designpatterns.localdatasource.LocalDataSource
import javax.inject.Inject

/**   Project property of BCP
 *   Created by Dazzord.
 */

class BatteryInfoRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val batteryInfoModelToBatteryInfoEntityMapper: BatteryInfoModelToBatteryInfoEntityMapper
) : BatteryInfoRepository {

    override fun getBatteryInfo(): List<BatteryInfoEntity> {
        return localDataSource.getBatteryInfo().map {
            batteryInfoModelToBatteryInfoEntityMapper.mapperTo(it)
        }
    }
}