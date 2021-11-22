package com.sample.kotlin_mvvm_hilt_flow_ktor.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.sample.kotlin_mvvm_hilt_flow_ktor.network.DogService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


/**
 * @author Ashik
 * Created on 14/11/21 .
 */
@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson {
        return GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    }

    @Singleton
    @Provides
    fun providesOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()
    }

    @Singleton
    @Provides
    fun provideConvertorFactory(gson: Gson): GsonConverterFactory =
        GsonConverterFactory.create(gson)

    @Singleton
    @Provides
    fun providesRetrofit(
        factory: GsonConverterFactory,
        client: OkHttpClient, @BaseUrl baseUrl: String
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(factory)
            .build()
    }

    @Singleton
    @Provides
    @BaseUrl
    fun provideBaseUrl(): String {
        return "https://dog.ceo/"
    }

    @Singleton
    @Provides
    fun provideDogService(retrofit: Retrofit): DogService {
        return retrofit.create(DogService::class.java)
    }
}
