package com.ojanbelajar.obuce.ui.tab.statistic.tab.history.repo

import com.ojanbelajar.obuce.ui.tab.statistic.tab.history.db.HistoryDao
import com.ojanbelajar.obuce.data.source.local.entity.HistoryEntity

class HistoryRepository(private val subscriberDAO: HistoryDao) {

    suspend fun insert(subscriber: HistoryEntity):Long {
        return subscriberDAO.insertSubscriber(subscriber)
    }
//    suspend fun insertInitNull(arraylistHistory:ArrayList<HistoryEntity>):ArrayList<Long> {
//        return subscriberDAO.insertInitNullSubscriber(arraylistHistory)
//
//    }




//    suspend fun update(subscriber: HistoryEntity):Int{
//        return subscriberDAO.updateSubscriber(subscriber)
//    }
//
//    suspend fun delete(subscriber: HistoryEntity):Int{
//        return subscriberDAO.deleteSubscriber(subscriber)
//    }
//
//    suspend fun deleteAll():Int{
//        return subscriberDAO.deleteAll()
//    }

    val subscribers = subscriberDAO.getAllSubscribers()
}