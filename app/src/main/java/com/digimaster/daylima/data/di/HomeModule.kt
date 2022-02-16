package com.digimaster.daylima.data.di


import com.digimaster.daylima.data.remote.HomeRemoteDataSource
import com.digimaster.daylima.data.remote.HomeRemoteDataSourceImpl
import com.digimaster.daylima.data.repository.HomeRepository
import com.digimaster.daylima.data.repository.HomeRepositoryImpl
import com.digimaster.daylima.data.service.HomeRetrofit
import com.digimaster.daylima.data.service.HomeService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class HomeModule {
    @Provides
    @Singleton
    fun provideRepository(homeRemoteDataSource: HomeRemoteDataSource): HomeRepository {
        return HomeRepositoryImpl(homeRemoteDataSource)
    }

    @Provides
    @Singleton
    fun provideRemoteDataSource(homeService: HomeService): HomeRemoteDataSource {
        return HomeRemoteDataSourceImpl(homeService)
    }

    @Provides
    @Singleton
    fun provideHomeService(): HomeService {
        return HomeRetrofit.homeService
    }
}