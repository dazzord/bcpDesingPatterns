package bcp.designpatterns.featurebatteryinfo.presentation.mapper

import bcp.designpatterns.core.mapper.Mapper
import bcp.designpatterns.featurebatteryinfo.domain.entity.BatteryInfoEntity

/**   Project property of BCP
 *   Created by Dazzord.
 */

class BatteryInfoEntityToPresentationModelMapper :
    Mapper<BatteryInfoEntity, BatteryInfoPresentationModel> {

    override fun mapperTo(input: BatteryInfoEntity): BatteryInfoPresentationModel =
        with(input) {
            BatteryInfoPresentationModel(
                icon = icon,
                text = text,
                value = value
            )
        }
}