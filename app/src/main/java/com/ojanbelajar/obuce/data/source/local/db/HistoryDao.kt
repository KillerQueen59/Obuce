package com.ojanbelajar.obuce.data.source.local.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ojanbelajar.obuce.data.source.local.entity.HistoryEntity

@Dao
interface HistoryDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertSubscriber(history: HistoryEntity): Long

//    @Insert(onConflict = OnConflictStrategy.IGNORE)
//    suspend fun insertInitNullSubscriber(history: ArrayList<HistoryEntity>): ArrayList<Long>
//

    @Query("SELECT * FROM history_data_table")
    fun getAllSubscribers(): LiveData<List<HistoryEntity>>



    //    @Update
//    suspend fun updateSubscriber(history: HistoryEntity):Int
//
//    @Delete
//    suspend fun deleteSubscriber(history: HistoryEntity):Int

//    @Query("DELETE FROM history_data_table")
//    suspend fun deleteAll():Int
}