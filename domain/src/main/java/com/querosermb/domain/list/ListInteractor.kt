package com.querosermb.domain.list

import com.querosermb.data.http.DataException
import com.querosermb.data.http.ListRepository
import com.querosermb.data.local.ExchangeDao
import com.querosermb.domain.model.Exchange
import com.querosermb.domain.model.toDomain
import com.querosermb.domain.model.toExchangeEntity

class ListInteractor(
    private val listRepository: ListRepository,
    private val exchangeDao: ExchangeDao
) {
    suspend fun getItems(): Result<List<Exchange>> {
        return try {
            val result = listRepository.getItems()

            result.fold(
                onSuccess = { exchanges ->
                    if (exchanges.isEmpty()) {
                        return Result.failure(ListError.EmptyResponse)
                    }

                    val exchangeEntities = exchanges.map { exchange ->
                        val exchangeEntity = exchange.toExchangeEntity()
                        exchangeDao.insert(exchangeEntity)
                        exchangeEntity.toDomain()
                    }

                    Result.success(exchangeEntities)
                },
                onFailure = { error ->
                    Result.failure(
                        when (error) {
                            is DataException.EmptyResponseException -> ListError.EmptyResponse
                            is DataException.NetworkException -> ListError.NetworkError
                            is DataException.ApiException -> ListError.ApiError(error.code)
                            else -> ListError.UnknownError
                        }
                    )
                }
            )
        } catch (e: Exception) {
            Result.failure(ListError.UnknownError)
        }
    }
}
