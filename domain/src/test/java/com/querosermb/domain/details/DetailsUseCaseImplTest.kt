package com.querosermb.domain.details

import com.querosermb.data.local.ExchangeDao
import com.querosermb.data.local.ExchangeEntity
import com.querosermb.domain.model.Exchange
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class DetailsUseCaseImplTest {

    private lateinit var exchangeDao: ExchangeDao
    private lateinit var detailsUseCaseImpl: DetailsUseCaseImpl

    @Before
    fun setUp() {
        exchangeDao = mockk()
        detailsUseCaseImpl = DetailsUseCaseImpl(exchangeDao)
    }

    @Test
    fun `test getExchange returns exchange when found`() = runBlocking {
        val id = "123"
        val exchangeEntity = ExchangeEntity(exchangeId = id)
        val exchange = Exchange(exchangeId = id)

        coEvery { exchangeDao.selectExchangeById(id) } returns exchangeEntity

        val result = detailsUseCaseImpl.getExchange(id)

        assertEquals(exchange, result)
        coVerify { exchangeDao.selectExchangeById(id) }
    }

    @Test
    fun `test getExchange returns null when not found`() = runBlocking {
        val id = "123"

        coEvery { exchangeDao.selectExchangeById(id) } returns null

        val result = detailsUseCaseImpl.getExchange(id)

        assertEquals(null, result)
        coVerify { exchangeDao.selectExchangeById(id) }
    }
}
