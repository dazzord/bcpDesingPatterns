package bcp.designpatterns.featurehome.presentation

import bcp.designpatterns.core.extentions.DoNothing
import bcp.designpatterns.core.usecase.UseCaseExecutorProvider
import bcp.designpatterns.core.viewmodel.BaseViewModel
import bcp.designpatterns.featurehome.domain.GetHomeHeaderTitleUseCase
import bcp.designpatterns.featurehome.domain.entity.HomeEntity
import bcp.designpatterns.featurehome.presentation.mapper.HomeEntityToHomePresentationModelMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**   Project property of BCP
 *   Created by Dazzord.
 */

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getHomeHeaderTitleUseCase: GetHomeHeaderTitleUseCase,
    private val homeEntityToPresentationMapper: HomeEntityToHomePresentationModelMapper,
    useCaseExecutorProvider: UseCaseExecutorProvider
) : BaseViewModel<HomeViewState, Nothing>(useCaseExecutorProvider) {

    init {
        fetchHomeInfo()
    }

    override fun initialState(): HomeViewState = HomeViewState()

    private fun fetchHomeInfo() {
        execute(getHomeHeaderTitleUseCase, DoNothing, ::onHomeInfoFetched)
    }

    private fun onHomeInfoFetched(homeEntity: HomeEntity) {
        val homePresentationModel = homeEntityToPresentationMapper.mapperTo(homeEntity)
        updateViewState { homeInfoReady(homePresentationModel) }
    }
}