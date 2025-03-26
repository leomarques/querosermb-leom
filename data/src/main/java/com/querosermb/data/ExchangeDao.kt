package com.querosermb.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ExchangeDao {
    @Query("SELECT * FROM `exchange`")
    suspend fun selectExchanges(): List<ExchangeEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(exchangeEntity: ExchangeEntity)

    @Update
    suspend fun update(accountEntity: ExchangeEntity)
}
