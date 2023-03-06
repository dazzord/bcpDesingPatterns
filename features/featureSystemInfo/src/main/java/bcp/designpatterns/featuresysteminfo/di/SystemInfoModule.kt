package bcp.designpatterns.featuresysteminfo.di

import bcp.designpatterns.core.coroutine.CoroutineContextProvider
import bcp.designpatterns.featuresysteminfo.data.repository.SystemInfoRepositoryImpl
import bcp.designpatterns.featuresysteminfo.domain.GetSystemInfoUseCase
import bcp.designpatterns.featuresysteminfo.domain.repository.SystemInfoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**   Project property of BCP
 *   Created by Dazzord.
 */

@Module
@InstallIn(SingletonComponent::class)
object SystemInfoModule {

    @Provides
    fun providesSystemInfoRepository(repository: SystemInfoRepositoryImpl): SystemInfoRepository =
        repository

    @Provides
    fun providesSystemInfoUseCase(
        repo: SystemInfoRepository,
        coroutineContextProvider: CoroutineContextProvider
    ): GetSystemInfoUseCase = GetSystemInfoUseCase(repo, coroutineContextProvider)
}