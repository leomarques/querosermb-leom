package com.querosermb.domain.details

import com.querosermb.data.local.ExchangeDao
import com.querosermb.data.local.ExchangeEntity
import com.querosermb.domain.model.Exchange

class DetailsInteractor(private val exchangeDao: ExchangeDao) {
    suspend fun getExchange(id: String): Exchange {
        return exchangeDao.selectExchangeById(id).toDomain()
    }
}

private fun ExchangeEntity?.toDomain(): Exchange {
    return Exchange(
        exchangeId = this?.exchangeId ?: "",
        name = this?.name ?: "",
        volume1dayUsd = this?.volume1dayUsd ?: 0.0
    )
}
