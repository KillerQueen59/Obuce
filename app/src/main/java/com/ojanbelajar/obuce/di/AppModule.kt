package com.ojanbelajar.obuce.di

import android.content.Context
import com.ojanbelajar.obuce.data.source.ObuceRepository
import com.ojanbelajar.obuce.data.source.Repository
import com.ojanbelajar.obuce.data.source.remote.RemoteDataInterface
import com.ojanbelajar.obuce.data.source.remote.RemoteDataSource
import com.ojanbelajar.obuce.data.source.remote.network.ApiService
import com.ojanbelajar.obuce.utils.SessionManagement
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import okhttp3.Request



@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Provides
    fun provideBase() = "http://34.126.169.20/v1/"

    @Singleton
    @Provides
    fun provideSharedPreference(@ApplicationContext context: Context): SessionManagement {
        return SessionManagement(context)
    }

    @Singleton
    @Provides
    fun provideHttpClient(sessionManagement: SessionManagement): OkHttpClient = OkHttpClient.Builder().addInterceptor(Interceptor { chain ->
        val token = sessionManagement.token
        val newRequest: Request = chain.request().newBuilder()
            .addHeader("Authorization", "Bearer $token")
            .build()
        chain.proceed(newRequest)
    }).build()

    @Provides
    fun provideRetrofitInstance(okHttpClient: OkHttpClient, BASEURL: String): Retrofit = Retrofit.Builder().apply {
        baseUrl(BASEURL)
        client(okHttpClient)
        addConverterFactory(GsonConverterFactory.create())
    }.build()


    @Provides
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