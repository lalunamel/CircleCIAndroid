package net.codysehl.circleciandroid.usecases.onboarding.createapikey

import android.content.Context
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
import net.codysehl.circleciandroid.utils.observeNotNull

class CreateApiKeyFragment: Fragment() {

    private val viewModel = CreateApiKeyViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentCreateApiKeyBinding>(inflater, R.layout.fragment_create_api_key, container, false)

        binding.viewModel = viewModel
        lifecycle.addObserver(viewModel)

        viewModel.uiEvents.observeNotNull(this, ::handleUiEvents)

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycle.addObserver(viewModel)
    }

    private fun handleUiEvents(uiEvent: CreateApiKeyViewModel.UiEvent) {
        when (uiEvent) {
            is CreateApiKeyViewModel.UiEvent.OpenUrl -> openUrl(uiEvent)
        }
    }

    private fun openUrl(uiEvent: CreateApiKeyViewModel.UiEvent.OpenUrl) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(uiEvent.url)
        startActivity(intent)
    }
}