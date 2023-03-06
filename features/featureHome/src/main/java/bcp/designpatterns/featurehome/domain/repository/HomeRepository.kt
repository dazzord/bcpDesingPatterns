package bcp.designpatterns.featurehome.domain.repository

import bcp.designpatterns.featurehome.domain.entity.HomeEntity

/**   Project property of BCP
 *   Created by Dazzord.
 */

interface HomeRepository {

    fun getHomeHeaderTitle(): HomeEntity
}