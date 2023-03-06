package bcp.designpatterns.featuresysteminfo.domain

import bcp.designpatterns.core.coroutine.CoroutineContextProvider
import bcp.designpatterns.core.usecase.BackgroundExecutingUseCase
import bcp.designpatterns.featuresysteminfo.domain.entity.SystemInfoEntity
import bcp.designpatterns.featuresysteminfo.domain.repository.SystemInfoRepository

/**   Project property of BCP
 *   Created by Dazzord.
 */
class GetSystemInfoUseCase(
    private val systemInfoRepository: SystemInfoRepository,
    coroutineContextProvider: CoroutineContextProvider
) : BackgroundExecutingUseCase<Unit, List<SystemInfoEntity>>(coroutineContextProvider) {

    override fun executeInBackground(request: Unit): List<SystemInfoEntity> =
        systemInfoRepository.getSystemInfo()
}