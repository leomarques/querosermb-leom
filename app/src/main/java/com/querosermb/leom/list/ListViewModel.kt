package com.querosermb.leom.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.querosermb.domain.list.ListError
import com.querosermb.domain.list.ListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ListViewModel(private val listUseCase: ListUseCase) : ViewModel() {
    private val _state = MutableStateFlow(ListState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _state.update { it.copy(isLoading = true) }
            val result = listUseCase.getItems()
            _state.update {
                result.fold(
                    onSuccess = { exchanges ->
                        ListState(
                            items = exchanges,
                            isLoading = false
                        )
                    },
                    onFailure = { error ->
                        ListState(
                            isLoading = false,
                            errorMessage =
                                when (error) {
                                    ListError.EmptyResponse -> "No data available."
                                    ListError.NetworkError -> "Check your internet connection."
                                    ListError.UnknownError -> "Something went wrong."
                                    is ListError.ApiError -> "Server error: ${error.code}"
                                    else -> "Something went wrong."
                                }
                        )
                    }
                )
            }
        }
    }
}
