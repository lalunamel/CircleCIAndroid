package net.codysehl.circleciandroid.usecases.onboarding

import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import net.codysehl.circleciandroid.CircleCiAndroidApplication
import net.codysehl.circleciandroid.R
import net.codysehl.circleciandroid.databinding.ActivityOnboardingBinding
import net.codysehl.circleciandroid.utils.observeNotNull

class OnboardingActivity : AppCompatActivity() {

    private val viewModel = OnboardingViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycle.addObserver(viewModel)

        val binding = DataBindingUtil.setContentView<ActivityOnboardingBinding>(
            this,
            R.layout.activity_onboarding
        )
        binding.viewModel = viewModel

        val application = application as CircleCiAndroidApplication

        viewModel.uiEvents.observeNotNull(this, ::handleUiEvents)

        val me = application.circleCiService
    }

    private fun handleUiEvents(uiEvent: OnboardingViewModel.UiEvent) {
        when (uiEvent) {
            is OnboardingViewModel.UiEvent.OpenUrl -> openUrl(uiEvent)
        }
    }

    private fun openUrl(uiEvent: OnboardingViewModel.UiEvent.OpenUrl) {
        val intent = Intent(ACTION_VIEW)
        intent.data = Uri.parse(uiEvent.url)
        startActivity(intent)
    }
}
