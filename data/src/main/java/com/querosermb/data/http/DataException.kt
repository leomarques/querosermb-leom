package com.querosermb.data.http

sealed class DataException(message: String, cause: Throwable? = null) : Exception(message, cause) {
    class NetworkException(cause: Throwable) : DataException("Network error", cause)
    class TimeoutException(cause: Throwable) : DataException("Request timed out", cause)
    class ApiException(val code: Int, message: String) : DataException("API error: $code - $message")

    data object UnknownException : DataException("Unknown error") {
        private fun readResolve(): Any = UnknownException
    }

    data object EmptyResponseException : DataException("Response body is empty") {
        private fun readResolve(): Any = EmptyResponseException
    }
}
