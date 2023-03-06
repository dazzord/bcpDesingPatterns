package bcp.designpatterns.featurehome.data.mapper

import bcp.designpatterns.core.mapper.Mapper
import bcp.designpatterns.featurehome.domain.entity.HomeEntity

/**   Project property of BCP
 *   Created by Dazzord.
 */

class PairHomeTitleToHomeEntityMapper : Mapper<Pair<String, String>, HomeEntity> {

    override fun mapperTo(input: Pair<String, String>): HomeEntity = HomeEntity(
        toolbarLinearTitle = input.first,
        toolbarLinearSubtitle = input.second
    )
}