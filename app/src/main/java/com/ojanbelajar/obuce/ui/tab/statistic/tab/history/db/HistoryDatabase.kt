package com.ojanbelajar.obuce.ui.tab.statistic.tab.history.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ojanbelajar.obuce.data.source.local.entity.HistoryEntity

@Database(entities = [HistoryEntity::class],version = 2)
abstract class HistoryDatabase:RoomDatabase() {

    abstract val dao: HistoryDao

    companion object{
        @Volatile
        private var INSTANCE : HistoryDatabase? = null
        fun getInstance(context: Context): HistoryDatabase {
            synchronized(this){
                var instance = INSTANCE
                if(instance==null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        HistoryDatabase::class.java,
                        "history_data_database"
                    ).build()
                }
                return instance
            }
        }

    }
}