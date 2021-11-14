package com.sample.kotlin_mvvm_hilt_flow_ktor.di

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.sample.kotlin_mvvm_hilt_flow_ktor.network.UserService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
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
    fun providesOkHttpClient(
        @ApplicationContext context: Context
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()
    }

    @Singleton
    @Provides
    fun providesRetrofit(
        factory: Converter.Factory,
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
        return "https://jsonplaceholder.typicode.com"
    }

    @Provides
    fun provideUserService(retrofit: Retrofit.Builder): UserService {
        return retrofit.build().create(UserService::class.java)
    }
}
