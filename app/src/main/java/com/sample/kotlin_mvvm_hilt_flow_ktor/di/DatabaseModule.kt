package com.sample.kotlin_mvvm_hilt_flow_ktor.di

import android.content.Context
import androidx.room.Room
import com.sample.kotlin_mvvm_hilt_flow_ktor.data.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


/**
 * @author Ashik
 * Created on 14/11/21 .
 */
@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun providesDatabase(
        @ApplicationContext context: Context,
        @DatabaseName dbName: String
    ): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, dbName)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    @DatabaseName
    fun provideDbName(): String {
        return AppDatabase.MY_DB
    }
}
