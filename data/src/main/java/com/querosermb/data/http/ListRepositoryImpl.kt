package com.querosermb.data.http

import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException

class ListRepositoryImpl(private val apiService: CoinApiService) : ListRepository {
    override suspend fun getItems(): Result<APIResponse> {
        return try {
            val body = apiService.getExchanges().body()
            if (body != null) {
                Result.success(body)
            } else {
                return Result.failure(DataException.EmptyResponseException )
            }
        } catch (e: IOException) {
            Result.failure(DataException.NetworkException(e))
        } catch (e: SocketTimeoutException) {
            Result.failure(DataException.TimeoutException(e))
        } catch (e: HttpException) {
            Result.failure(DataException.ApiException(e.code(), e.message()))
        } catch (e: Exception) {
            Result.failure(DataException.UnknownException)
        }
    }
}
