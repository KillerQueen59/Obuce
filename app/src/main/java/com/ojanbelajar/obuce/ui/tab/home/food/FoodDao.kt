package com.ojanbelajar.obuce.ui.tab.home.food

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ojanbelajar.obuce.data.source.local.entity.FoodEntity

@Dao
interface FoodDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertSubscriber(foodEntity: FoodEntity): Long


    @Query("SELECT * FROM food_recommend_data_table")
    fun getAllSubscribers(): LiveData<List<FoodEntity>>

    //    @Insert(onConflict = OnConflictStrategy.IGNORE)
//    suspend fun insertInitNullSubscriber(history: ArrayList<HistoryEntity>): ArrayList<Long>
//

}