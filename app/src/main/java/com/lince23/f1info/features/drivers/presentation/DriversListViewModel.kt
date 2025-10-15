package com.lince23.f1info.features.drivers.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lince23.f1info.features.drivers.domain.Driver
import com.lince23.f1info.features.drivers.domain.ErrorApp
import com.lince23.f1info.features.drivers.domain.GetDriversListUseCase
import kotlinx.coroutines.launch

class DriversListViewModel(private val getDriversListUseCase: GetDriversListUseCase) : ViewModel() {
    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState

    fun loadDrivers() {
        viewModelScope.launch {
            _uiState.value = UiState(isLoading = true)
            getDriversListUseCase().fold(
                {
                    isSuccess(it)
                },
                {

                }
            )
        }
    }

    private fun isSuccess(drivers: List<Driver>) {
        _uiState.value = UiState(drivers = drivers.sortedBy { it.team })
    }

    private fun onFailure(error: ErrorApp) {
        _uiState.value = UiState(error = error)
    }

    data class UiState(
        val error: ErrorApp? = null,
        val isLoading: Boolean = false,
        val drivers: List<Driver>? = null
    )
}