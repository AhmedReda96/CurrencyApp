package com.example.currencyapp.app.ui.views.currencyConversions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.currencyapp.BuildConfig
import com.example.currencyapp.R
import com.example.currencyapp.app.ui.base.BaseFragment
import com.example.currencyapp.app.ui.viewModle.CurrencyViewmodel
import com.example.currencyapp.domain.model.latest.LatestRequest
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CurrencyConversionsFragment : BaseFragment() {
    private val viewModel: CurrencyViewmodel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_currency_conversions, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initVars()
    }

    private fun initVars() {
        lifecycleScope.launch {
            handleUI(viewState = viewModel.symbolsSF.value)
            handleUI(viewState = viewModel.ratesSF.value)
        }
        viewModel.getLatest(LatestRequest(BuildConfig.ACCESS_KEY,"USD"))
    }


}