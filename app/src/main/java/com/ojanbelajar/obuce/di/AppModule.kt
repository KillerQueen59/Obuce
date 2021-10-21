package com.ojanbelajar.obuce.di

import com.ojanbelajar.obuce.data.source.ObuceRepository
import com.ojanbelajar.obuce.data.source.Repository
import com.ojanbelajar.obuce.data.source.remote.RemoteDataInterface
import com.ojanbelajar.obuce.data.source.remote.RemoteDataSource
import com.ojanbelajar.obuce.data.source.remote.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Provides
    fun provideBase() = "http://34.126.169.20/v1/"

    @Singleton
    @Provides
    fun provideHttpClient(): OkHttpClient = OkHttpClient.Builder().apply {
        connectTimeout(30, TimeUnit.SECONDS)
        readTimeout(30, TimeUnit.SECONDS)
        writeTimeout(30, TimeUnit.SECONDS)
    }.build()

    @Singleton
    @Provides
    fun provideRetrofitInstance(okHttpClient: OkHttpClient, BASEURL: String): Retrofit = Retrofit.Builder().apply {
        baseUrl(BASEURL)
        client(okHttpClient)
        addConverterFactory(GsonConverterFactory.create())
    }.build()


    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit) = retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideContentRemoteSource(remoteSource: RemoteDataSource): RemoteDataInterface = remoteSource

    @Provides
    @Singleton
    fun provideContentRepository(
        contentRemoteSource: RemoteDataInterface,
    ): Repository = ObuceRepository(contentRemoteSource)
}