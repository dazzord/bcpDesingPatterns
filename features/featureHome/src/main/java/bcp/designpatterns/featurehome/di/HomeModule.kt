package bcp.designpatterns.featurehome.di

import bcp.designpatterns.core.coroutine.CoroutineContextProvider
import bcp.designpatterns.featurehome.data.mapper.PairHomeTitleToHomeEntityMapper
import bcp.designpatterns.featurehome.data.repository.HomeRepositoryImpl
import bcp.designpatterns.featurehome.domain.GetHomeHeaderTitleUseCase
import bcp.designpatterns.featurehome.domain.repository.HomeRepository
import bcp.designpatterns.featurehome.presentation.mapper.HomeEntityToHomePresentationModelMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**   Project property of BCP
 *   Created by Dazzord.
 */

@Module
@InstallIn(SingletonComponent::class)
object HomeModule {

    @Provides
    fun providesGetHomeHeaderUseCase(
        homeRepository: HomeRepository,
        coroutineContextProvider: CoroutineContextProvider
    ) = GetHomeHeaderTitleUseCase(
        homeRepository,
        coroutineContextProvider
    )

    @Provides
    fun providesPairHomeTitleToHomeEntityMapper() = PairHomeTitleToHomeEntityMapper()

    @Provides
    fun providesHomeEntityToHomePresentationModelMapper() =
        HomeEntityToHomePresentationModelMapper()

    @Provides
    fun providesHomeRepository(repository: HomeRepositoryImpl): HomeRepository = repository
}