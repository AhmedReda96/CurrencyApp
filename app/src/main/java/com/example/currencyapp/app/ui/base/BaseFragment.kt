package com.example.currencyapp.app.ui.base

import android.view.View
import androidx.fragment.app.Fragment
import com.example.currencyapp.app.utils.ConstantStrings
import com.example.currencyapp.app.utils.showLog
import com.example.currencyapp.domain.base.ApiResponse
import com.example.currencyapp.domain.base.NetworkingViewState

open class BaseFragment : Fragment(), View.OnClickListener {
    protected open fun handleUI(viewState: NetworkingViewState?) {
        when (viewState) {
            is NetworkingViewState.Loading -> {
                showLoader()
            }
            is NetworkingViewState.Error -> with(viewState) {
                try {
                    showLog(true, error.message.toString())
                } catch (e: Exception) {
                    showLog(true, e.message.toString())
                }
                dismissLoader()
            }

            is NetworkingViewState.Success<*> -> with(viewState) {
                (item as ApiResponse<*>).request = request
               handleResponse(item as ApiResponse<*>)
                dismissLoader()
            }
            else -> with(ConstantStrings.UNKNOWN_VIEW_STATE + this.javaClass.simpleName) {
                showLog(true, this)
            }
        }


    }

    private fun showLoader() {
    }

    private fun dismissLoader() {
    }
    protected open fun handleResponse(response: ApiResponse<*>) {
    }

    override fun onClick(p0: View?) {

    }
}