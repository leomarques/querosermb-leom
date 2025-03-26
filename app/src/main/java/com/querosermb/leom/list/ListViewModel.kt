package com.querosermb.leom.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.querosermb.domain.list.ListInteractor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ListViewModel(private val listInteractor: ListInteractor) : ViewModel() {
    private val _state = MutableStateFlow(ListState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val items = listInteractor.getItems()
            _state.update {
                ListState(
                    items = items,
                    isLoading = false
                )
            }
        }
    }
}
