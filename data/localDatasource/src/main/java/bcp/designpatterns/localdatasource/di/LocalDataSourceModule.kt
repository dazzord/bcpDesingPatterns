package bcp.designpatterns.localdatasource.di

import bcp.designpatterns.localdatasource.LocalDataSource
import bcp.designpatterns.localdatasource.LocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**   Project property of BCP
 *   Created by Dazzord.
 */

@Module
@InstallIn(SingletonComponent::class)
object LocalDataSourceModule {

    @Provides
    fun providesLocalDataSource(localDataSourceImpl: LocalDataSourceImpl): LocalDataSource =
        localDataSourceImpl
}