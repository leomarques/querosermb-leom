package com.querosermb.domain.list

import com.querosermb.data.http.APIResponse
import com.querosermb.data.http.DataException
import com.querosermb.data.http.ExchangeAPIModel
import com.querosermb.data.http.ListRepository
import com.querosermb.data.local.ExchangeDao
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class ListInteractorTest {

    private lateinit var listRepository: ListRepository
    private lateinit var exchangeDao: ExchangeDao
    private lateinit var listInteractor: ListInteractor

    @Before
    fun setUp() {
        listRepository = mockk()
        exchangeDao = mockk()
        listInteractor = ListInteractor(listRepository, exchangeDao)
    }

    @Test
    fun `test getItems returns success when data is fetched`() = runBlocking {
        val exchangeAPIModel = ExchangeAPIModel(exchangeId = "123",
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
        )
        val exchangesAPIResponse: APIResponse = listOf(exchangeAPIModel)

        coEvery { listRepository.getItems() } returns Result.success(exchangesAPIResponse)
        coEvery { exchangeDao.insert(any()) } returns Unit

        val result = listInteractor.getItems()

        assertTrue(result.isSuccess)
        assertEquals(1, result.getOrNull()?.size)
        coVerify { exchangeDao.insert(any()) }
    }

    @Test
    fun `test getItems returns failure with EmptyResponse error when list is empty`() = runBlocking {
        val exchangesAPIResponse: APIResponse = emptyList()

        coEvery { listRepository.getItems() } returns Result.success(exchangesAPIResponse)

        val result = listInteractor.getItems()

        assertTrue(result.isFailure)
        assertEquals(ListError.EmptyResponse, result.exceptionOrNull())
        coVerify(exactly = 0) { exchangeDao.insert(any()) }
    }

    @Test
    fun `test getItems returns failure with NetworkError when network exception occurs`() = runBlocking {
        val networkException = DataException.NetworkException(Exception("Network error"))

        coEvery { listRepository.getItems() } returns Result.failure(networkException)

        val result = listInteractor.getItems()

        assertTrue(result.isFailure)
        assertEquals(ListError.NetworkError, result.exceptionOrNull())
        coVerify(exactly = 0) { exchangeDao.insert(any()) }
    }

    @Test
    fun `test getItems returns failure with ApiError when api exception occurs`() = runBlocking {
        val apiException = DataException.ApiException(404, "API error")

        coEvery { listRepository.getItems() } returns Result.failure(apiException)

        val result = listInteractor.getItems()

        assertTrue(result.isFailure)
        assertEquals(ListError.ApiError(404), result.exceptionOrNull())
        coVerify(exactly = 0) { exchangeDao.insert(any()) }
    }

    @Test
    fun `test getItems returns failure with UnknownError when an unexpected exception occurs`() = runBlocking {
        val exception = Exception("Unknown error")

        coEvery { listRepository.getItems() } throws exception

        val result = listInteractor.getItems()

        assertTrue(result.isFailure)
        assertEquals(ListError.UnknownError, result.exceptionOrNull())
        coVerify(exactly = 0) { exchangeDao.insert(any()) }
    }
}
