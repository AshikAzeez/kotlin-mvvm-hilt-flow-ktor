package com.sample.kotlin_mvvm_hilt_flow_ktor.data.db

import androidx.room.Database
import androidx.room.RoomDatabase


/**
 * @author Ashik
 * Created on 14/11/21 .
 */
@Database(entities = [], version = 1)
abstract class AppDatabase:RoomDatabase(){

    companion object{
        const val MY_DB="my_db"
    }
}
