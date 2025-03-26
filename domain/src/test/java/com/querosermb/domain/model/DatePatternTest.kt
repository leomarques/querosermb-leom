package com.querosermb.domain.model

import org.junit.Assert.*
import org.junit.Test
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter

class StringExtensionsTest {

    @Test
    fun `test toPattern formats correctly`() {
        // Arrange
        val input = "2025-03-26T10:15:30+01:00"
        val expectedOutput = "26/03/2025 - 10:15:30"

        // Act
        val result = input.toPattern()

        // Assert
        assertEquals(expectedOutput, result)
    }

    @Test
    fun `test toPattern handles different time zone`() {
        // Arrange
        val input = "2025-03-26T10:15:30-05:00"
        val expectedOutput = "26/03/2025 - 10:15:30"

        // Act
        val result = input.toPattern()

        // Assert
        assertEquals(expectedOutput, result)
    }

    @Test(expected = java.time.format.DateTimeParseException::class)
    fun `test toPattern throws exception on invalid input`() {
        // Arrange
        val invalidInput = "invalid-date-time"

        // Act
        invalidInput.toPattern()  // Should throw an exception
    }
}
