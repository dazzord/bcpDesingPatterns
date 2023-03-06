package bcp.designpatterns.featuresysteminfo.domain.repository

import bcp.designpatterns.featuresysteminfo.domain.entity.SystemInfoEntity

/**   Project property of BCP
 *   Created by Dazzord.
 */
interface SystemInfoRepository {

    fun getSystemInfo(): List<SystemInfoEntity>
}