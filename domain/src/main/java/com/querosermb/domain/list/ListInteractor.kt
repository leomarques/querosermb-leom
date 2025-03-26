package com.querosermb.domain.list

import com.querosermb.data.http.ListRepository
import com.querosermb.data.local.ExchangeDao
import com.querosermb.domain.model.Exchange
import com.querosermb.domain.model.toDomain
import com.querosermb.domain.model.toExchangeEntity

class ListInteractor(
    private val listRepository: ListRepository,
    private val exchangeDao: ExchangeDao
) {
    suspend fun getItems(): List<Exchange> {
        val items = listRepository.getItems()

        val exchangeEntities = items.map { item ->
            val exchangeEntity = item.toExchangeEntity()
            exchangeDao.insert(exchangeEntity)
            exchangeEntity
        }

        return exchangeEntities.map { entity ->
            entity.toDomain()
        }
    }
}
