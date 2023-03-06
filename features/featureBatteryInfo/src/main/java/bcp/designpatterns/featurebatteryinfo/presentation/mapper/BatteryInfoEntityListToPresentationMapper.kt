package bcp.designpatterns.featurebatteryinfo.presentation.mapper

import bcp.designpatterns.core.mapper.Mapper
import bcp.designpatterns.featurebatteryinfo.domain.entity.BatteryInfoEntity
import javax.inject.Inject

/**   Project property of BCP
 *   Created by Dazzord.
 */

class BatteryInfoEntityListToPresentationMapper @Inject constructor() :
    Mapper<List<BatteryInfoEntity>, List<BatteryInfoPresentationModel>> {

    override fun mapperTo(input: List<BatteryInfoEntity>): List<BatteryInfoPresentationModel> =
        input.map { BatteryInfoEntityToPresentationModelMapper().mapperTo(it) }
}