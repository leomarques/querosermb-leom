package com.querosermb.data

import com.querosermb.data.http.APIResponse
import com.querosermb.data.http.CoinApiService
import com.querosermb.data.http.DataException
import com.querosermb.data.http.ExchangeAPIModel
import com.querosermb.data.http.ListRepositoryImpl
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import retrofit2.HttpException
import java.io.IOException

class ListRepositoryImplTest {

    private lateinit var apiService: CoinApiService
    private lateinit var listRepository: ListRepositoryImpl

    @Before
    fun setUp() {
        apiService = mockk()
        listRepository = ListRepositoryImpl(apiService)
    }

    @Test
    fun `test getItems returns success when response body is not null`() = runBlocking {
        val exchangeApiResponse: APIResponse = listOf(ExchangeAPIModel(
            exchangeId = "123",
            website = null,
            name = null,
            dataQuoteStart = null,
            dataQuoteEnd = null,
            dataOrderbookStart = null,
            dataOrderbookEnd = null,
            dataTradeStart = null,
            dataTradeEnd = null,
            dataSymbolsCount = null,
            volume1hrsUsd = null,
            volume1dayUsd = null,
            volume1mthUsd = null,
            rank = null
        ))
        coEvery { apiService.getExchanges().body() } returns exchangeApiResponse

        val result = listRepository.getItems()

        assertTrue(result.isSuccess)
        assertEquals(exchangeApiResponse, result.getOrNull())
    }

    @Test
    fun `test getItems returns failure with EmptyResponseException when response body is null`() = runBlocking {
        coEvery { apiService.getExchanges().body() } returns null

        val result = listRepository.getItems()

        assertTrue(result.isFailure)
        assertEquals(DataException.EmptyResponseException, result.exceptionOrNull())
    }

    @Test
    fun `test getItems returns failure with NetworkException when IOException occurs`() = runBlocking {
        val ioException = IOException("Network error")
        coEvery { apiService.getExchanges().body() } throws ioException

        val result = listRepository.getItems()

        assertTrue(result.isFailure)
        assertTrue(result.exceptionOrNull() is DataException.NetworkException)
    }

    @Test
    fun `test getItems returns failure with ApiException when HttpException occurs`() = runBlocking {
        val httpException = HttpException(retrofit2.Response.error<Any>(500, okhttp3.ResponseBody.create(null, "Error")))
        coEvery { apiService.getExchanges().body() } throws httpException

        val result = listRepository.getItems()

        assertTrue(result.isFailure)
        assertTrue(result.exceptionOrNull() is DataException.ApiException)
    }

    @Test
    fun `test getItems returns failure with UnknownException when a generic exception occurs`() = runBlocking {
        val exception = Exception("Unknown error")
        coEvery { apiService.getExchanges().body() } throws exception

        val result = listRepository.getItems()

        assertTrue(result.isFailure)
        assertEquals(DataException.UnknownException, result.exceptionOrNull())
    }
}
