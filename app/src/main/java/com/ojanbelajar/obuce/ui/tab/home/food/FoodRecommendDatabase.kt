package com.ojanbelajar.obuce.ui.tab.home.food

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ojanbelajar.obuce.ui.tab.statistic.tab.history.db.HistoryDao
import com.ojanbelajar.obuce.ui.tab.statistic.tab.history.db.HistoryDatabase
import com.ojanbelajar.obuce.data.source.local.entity.FoodEntity
import com.ojanbelajar.obuce.data.source.local.entity.HistoryEntity
import com.ojanbelajar.obuce.utils.Converters

@Database(entities = [FoodEntity::class],version = 1)
@TypeConverters(Converters::class)
abstract class FoodRecommendDatabase: RoomDatabase() {

    abstract val dao: FoodRecommendDao

    companion object{
        @Volatile
        private var INSTANCE : FoodRecommendDatabase? = null
        fun getInstance(context: Context): FoodRecommendDatabase {
            synchronized(this){
                var instance = INSTANCE
                if(instance==null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        FoodRecommendDatabase::class.java,
                        "food_recommend_data_database"
                    ).build()
                }
                return instance
            }
        }

    }
}