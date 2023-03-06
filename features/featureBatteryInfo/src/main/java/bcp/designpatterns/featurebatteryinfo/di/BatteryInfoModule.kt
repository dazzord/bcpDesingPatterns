package bcp.designpatterns.featurebatteryinfo.di

import bcp.designpatterns.core.constants.Constants
import bcp.designpatterns.core.coroutine.CoroutineContextProvider
import bcp.designpatterns.featurebatteryinfo.data.BatteryInfoRepositoryImpl
import bcp.designpatterns.featurebatteryinfo.data.mapper.BatteryInfoModelToBatteryInfoEntityMapper
import bcp.designpatterns.featurebatteryinfo.domain.GetBatteryInfoUseCase
import bcp.designpatterns.featurebatteryinfo.domain.repository.BatteryInfoRepository
import bcp.designpatterns.featurebatteryinfo.domain.repository.fake.FakeBatteryInfoRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Qualifier

/**   Project property of BCP
 *   Created by Dazzord.
 */

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class BatteryInfoRepositoryScope

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class FakeBatteryInfoRepository

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class FakeBatteryInfoUseCase

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class BatteryInfoUseCase

@Module
@InstallIn(SingletonComponent::class)
object BatteryInfoModule {

    @Provides
    fun providesBatteryInfoMapper() = BatteryInfoModelToBatteryInfoEntityMapper()


    @BatteryInfoRepositoryScope
    @Provides
    fun providesBatteryInfoRepository(batteryInfoRepository: BatteryInfoRepositoryImpl): BatteryInfoRepository =
        batteryInfoRepository

    @FakeBatteryInfoRepository
    @Provides
    fun providesFakeBatteryInfoRepository(batteryInfoRepository: FakeBatteryInfoRepositoryImpl): BatteryInfoRepository =
        batteryInfoRepository

    @FakeBatteryInfoUseCase
    @Provides
    fun providesFakeBatteryInfoUseCase(
       batteryInfoRepository: FakeBatteryInfoRepositoryImpl,
        coroutineContextProvider: CoroutineContextProvider
    ) = GetBatteryInfoUseCase(
        batteryInfoRepository,
        coroutineContextProvider
    )

    @BatteryInfoUseCase
    @Provides
    fun providesBatteryInfoUseCase(
        batteryInfoRepository: BatteryInfoRepositoryImpl,
        coroutineContextProvider: CoroutineContextProvider
    ) = GetBatteryInfoUseCase(
        batteryInfoRepository,
        coroutineContextProvider
    )
}