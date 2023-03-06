package bcp.designpatterns.featurehome.data.repository

import bcp.designpatterns.featurehome.data.mapper.PairHomeTitleToHomeEntityMapper
import bcp.designpatterns.featurehome.domain.entity.HomeEntity
import bcp.designpatterns.featurehome.domain.repository.HomeRepository
import bcp.designpatterns.localdatasource.LocalDataSource
import javax.inject.Inject

/**   Project property of BCP
 *   Created by Dazzord.
 */

class HomeRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val pairHomeTitleToHomeEntityMapper: PairHomeTitleToHomeEntityMapper
) : HomeRepository {

    override fun getHomeHeaderTitle(): HomeEntity {
        return pairHomeTitleToHomeEntityMapper.mapperTo(localDataSource.getHomeHeaderTitle())
    }
}