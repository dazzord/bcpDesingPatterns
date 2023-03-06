package bcp.designpatterns.featurehome.presentation.mapper

import bcp.designpatterns.core.mapper.Mapper
import bcp.designpatterns.featurehome.domain.entity.HomeEntity
import bcp.designpatterns.featurehome.presentation.HomePresentationModel

/**   Project property of BCP
 *   Created by Dazzord.
 */

class HomeEntityToHomePresentationModelMapper : Mapper<HomeEntity, HomePresentationModel> {

    override fun mapperTo(input: HomeEntity): HomePresentationModel = HomePresentationModel(
        toolbarLinearTitle = input.toolbarLinearTitle,
        toolbarLinearSubtitle = input.toolbarLinearSubtitle
    )
}