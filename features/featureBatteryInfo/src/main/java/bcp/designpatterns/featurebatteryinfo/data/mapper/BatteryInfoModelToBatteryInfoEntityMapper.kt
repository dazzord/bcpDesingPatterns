package bcp.designpatterns.featurebatteryinfo.data.mapper

import bcp.designpatterns.core.mapper.Mapper
import bcp.designpatterns.featurebatteryinfo.domain.entity.BatteryInfoEntity
import bcp.designpatterns.localdatasource.BatteryInfoModel

/**   Project property of BCP
 *   Created by Dazzord.
 */

class BatteryInfoModelToBatteryInfoEntityMapper : Mapper<BatteryInfoModel, BatteryInfoEntity> {

    override fun mapperTo(input: BatteryInfoModel): BatteryInfoEntity {
        return BatteryInfoEntity(
            icon = input.icon,
            text = input.text,
            value = input.value
        )
    }
}