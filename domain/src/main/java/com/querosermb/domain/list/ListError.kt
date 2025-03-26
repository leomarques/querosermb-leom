package com.querosermb.domain.list

sealed class ListError : Exception() {
    data object EmptyResponse : ListError() {
        private fun readResolve(): Any = EmptyResponse
    }

    data object NetworkError : ListError() {
        private fun readResolve(): Any = NetworkError
    }

    data class ApiError(val code: Int) : ListError()

    data object UnknownError : ListError() {
        private fun readResolve(): Any = UnknownError
    }
}
