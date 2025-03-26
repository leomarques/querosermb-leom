package com.querosermb.leom.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.querosermb.domain.details.DetailsInteractor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DetailsViewModel(
    private val detailsInteractor: DetailsInteractor,
) : ViewModel() {
    private val _state = MutableStateFlow(DetailsState())
    val state = _state.asStateFlow()

    fun updateId(id: String?) {
        _state.value = DetailsState()

        if (id == null) {
            _state.value =
                DetailsState(
                    isLoading = false,
                    isError = true
                )
        } else {
            viewModelScope.launch(Dispatchers.IO) {
                val item = detailsInteractor.getExchange(id)
                if (item == null) {
                    _state.value =
                        DetailsState(
                            isLoading = false,
                            isError = true
                        )
                } else {
                    _state.value =
                        DetailsState(
                            item = item,
                            isLoading = false,
                            isError = false
                        )
                }
            }
        }
    }
}
