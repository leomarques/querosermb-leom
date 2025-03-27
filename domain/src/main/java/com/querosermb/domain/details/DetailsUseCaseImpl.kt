package com.querosermb.domain.details

import com.querosermb.data.local.ExchangeDao
import com.querosermb.domain.model.Exchange
import com.querosermb.domain.model.toDomain

class DetailsUseCaseImpl(private val exchangeDao: ExchangeDao) : DetailsUseCase {
    override suspend fun getExchange(id: String): Exchange? {
        val toDomain = exchangeDao.selectExchangeById(id)?.toDomain()
        return toDomain
    }
}
