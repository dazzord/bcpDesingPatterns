package bcp.designpatterns.featuresysteminfo.data.repository

import bcp.designpatterns.featuresysteminfo.domain.entity.SystemInfoEntity
import bcp.designpatterns.featuresysteminfo.domain.repository.SystemInfoRepository
import bcp.designpatterns.localdatasource.LocalDataSource
import javax.inject.Inject

/**   Project property of BCP
 *   Created by Dazzord.
 */

class SystemInfoRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource
) : SystemInfoRepository {

    override fun getSystemInfo(): List<SystemInfoEntity> = localDataSource.getSystemInfo().map {
        SystemInfoEntity(
            type = it.first,
            value = it.second
        )
    }
}