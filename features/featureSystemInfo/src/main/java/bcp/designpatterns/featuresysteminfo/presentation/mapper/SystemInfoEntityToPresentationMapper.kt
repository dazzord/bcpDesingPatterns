package bcp.designpatterns.featuresysteminfo.presentation.mapper

import bcp.designpatterns.core.mapper.Mapper
import bcp.designpatterns.featuresysteminfo.domain.entity.SystemInfoEntity
import javax.inject.Inject

/**   Project property of BCP
 *   Created by Dazzord.
 */

class SystemInfoEntityToPresentationMapper @Inject constructor() :
    Mapper<List<SystemInfoEntity>, List<SystemInfoPresentationModel>> {

    override fun mapperTo(input: List<SystemInfoEntity>): List<SystemInfoPresentationModel> =
        with(input) {
            map {
                SystemInfoPresentationModel(
                    type = it.type,
                    value = it.value
                )
            }
        }
}
