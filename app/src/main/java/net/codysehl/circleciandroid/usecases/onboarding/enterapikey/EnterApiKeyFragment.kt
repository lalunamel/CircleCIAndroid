package net.codysehl.circleciandroid.usecases.onboarding.enterapikey

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import net.codysehl.circleciandroid.CircleCiAndroidApplication
import net.codysehl.circleciandroid.R
import net.codysehl.circleciandroid.databinding.FragmentEnterApiKeyBinding
import net.codysehl.circleciandroid.utils.observeNotNull

class EnterApiKeyFragment: Fragment() {

    private lateinit var viewModel: EnterApiKeyViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentEnterApiKeyBinding>(inflater, R.layout.fragment_enter_api_key, container, false)

        viewModel = EnterApiKeyViewModel(
            (activity?.application as CircleCiAndroidApplication).userRepository
        )

        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        lifecycle.addObserver(viewModel)

        viewModel.uiEvents.observeNotNull(this, ::handleUiEvents)

        return binding.root
    }

    private fun handleUiEvents(uiEvent: EnterApiKeyViewModel.UiEvent) {
        when (uiEvent) {
            is EnterApiKeyViewModel.UiEvent.ShowInvalidApiKeyMessage -> showInvalidApiKeyMessage()
        }
    }

    private fun showInvalidApiKeyMessage() {
        Toast.makeText(context, R.string.unable_to_authenticate_with_api_key, Toast.LENGTH_LONG).show()
    }
}