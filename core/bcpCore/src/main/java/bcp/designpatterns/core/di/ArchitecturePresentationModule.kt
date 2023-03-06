package bcp.designpatterns.core.di

import bcp.designpatterns.core.coroutine.CoroutineContextProvider
import bcp.designpatterns.core.usecase.UseCaseExecutor
import bcp.designpatterns.core.usecase.UseCaseExecutorProvider
import bcp.designpatterns.core.viewmodel.coroutine.AppCoroutineContextProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**   Project property of BCP
 *   Created by Dazzord.
 */

@Module
@InstallIn(SingletonComponent::class)
object ArchitecturePresentationModule {

    @Provides
    fun providesCoroutineContextProvider(): CoroutineContextProvider =
        AppCoroutineContextProvider()

    @Provides
    fun providesUseCaseExecutorProvider(): UseCaseExecutorProvider = ::UseCaseExecutor
}
