package com.querosermb.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface ExchangeDao {
    @Query("SELECT * FROM `exchange` where exchangeId = :id")
    suspend fun selectExchangeById(id: String): ExchangeEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(exchangeEntity: ExchangeEntity)
}
