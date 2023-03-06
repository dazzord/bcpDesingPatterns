package bcp.designpatterns.featurehome.domain

import bcp.designpatterns.core.coroutine.CoroutineContextProvider
import bcp.designpatterns.core.usecase.BackgroundExecutingUseCase
import bcp.designpatterns.featurehome.domain.entity.HomeEntity
import bcp.designpatterns.featurehome.domain.repository.HomeRepository
import javax.inject.Inject

/**   Project property of BCP
 *   Created by Dazzord.
 */

class GetHomeHeaderTitleUseCase @Inject constructor(
    private val homeRepository: HomeRepository,
    coroutineContextProvider: CoroutineContextProvider
) : BackgroundExecutingUseCase<Unit, HomeEntity>(coroutineContextProvider) {

    override fun executeInBackground(request: Unit): HomeEntity =
        homeRepository.getHomeHeaderTitle()
}