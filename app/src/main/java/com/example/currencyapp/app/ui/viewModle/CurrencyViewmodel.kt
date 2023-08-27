package com.example.currencyapp.app.ui.viewModle

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.currencyapp.domain.base.NetworkingViewState
import com.example.currencyapp.domain.model.latest.LatestRequest
import com.example.currencyapp.domain.model.symbols.SymbolRequest
import com.example.currencyapp.domain.repository.CurrencyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CurrencyViewmodel @Inject constructor(private val repo: CurrencyRepository) : ViewModel() {
    private var _ratesMSF =
        MutableStateFlow<NetworkingViewState>(NetworkingViewState.Loading())
    val ratesSF: StateFlow<NetworkingViewState> get() = _ratesMSF
    private var _symbolsMSF =
        MutableStateFlow<NetworkingViewState>(NetworkingViewState.Loading())
    val symbolsSF: StateFlow<NetworkingViewState> get() = _symbolsMSF


    fun getSymbols(request: SymbolRequest) {
        viewModelScope.launch {
            try {
                _symbolsMSF.emit(
                    NetworkingViewState.Success(
                        request,
                        repo.getSymbols(request)
                    )
                )

            } catch (e: Exception) {
                e.printStackTrace()
                _symbolsMSF.emit(NetworkingViewState.Error(e))
            }
        }
    }

    fun getLatest(request: LatestRequest) {
        viewModelScope.launch {
            try {
                _ratesMSF.emit(
                    NetworkingViewState.Success(
                        request,
                        repo.getLatest(request)
                    )
                )

            } catch (e: Exception) {
                e.printStackTrace()
                _ratesMSF.emit(NetworkingViewState.Error(e))
            }
        }
    }


}