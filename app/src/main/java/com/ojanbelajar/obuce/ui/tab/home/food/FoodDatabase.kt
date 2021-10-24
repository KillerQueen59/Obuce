package com.ojanbelajar.obuce.ui.tab.home.food

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ojanbelajar.obuce.data.source.local.entity.FoodEntity
import com.ojanbelajar.obuce.utils.Converters

@Database(entities = [FoodEntity::class],version = 1)
@TypeConverters(Converters::class)
abstract class FoodDatabase: RoomDatabase() {

    abstract val dao: FoodDao

    companion object{
        @Volatile
        private var INSTANCE : FoodDatabase? = null
        fun getInstance(context: Context): FoodDatabase {
            synchronized(this){
                var instance = INSTANCE
                if(instance==null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        FoodDatabase::class.java,
                        "food_recommend_data_database"
                    ).build()
                }
                return instance
            }
        }

    }
}