package net.codysehl.circleciandroid.usecases.onboarding.enterapikey

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import net.codysehl.circleciandroid.R
import net.codysehl.circleciandroid.databinding.FragmentCreateApiKeyBinding
import net.codysehl.circleciandroid.databinding.FragmentEnterApiKeyBinding
import net.codysehl.circleciandroid.usecases.onboarding.createapikey.CreateApiKeyViewModel
import net.codysehl.circleciandroid.utils.observeNotNull

class EnterApiKeyFragment: Fragment() {

    private val viewModel = EnterApiKeyViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentEnterApiKeyBinding>(inflater, R.layout.fragment_enter_api_key, container, false)

        binding.viewModel = viewModel
        lifecycle.addObserver(viewModel)

        viewModel.uiEvents.observeNotNull(this, ::handleUiEvents)

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycle.addObserver(viewModel)
    }

    private fun handleUiEvents(uiEvent: EnterApiKeyViewModel.UiEvent) {
        when (uiEvent) {
        }
    }
}