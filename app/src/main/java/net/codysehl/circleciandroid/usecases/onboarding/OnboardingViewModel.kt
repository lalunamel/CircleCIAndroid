package net.codysehl.circleciandroid.usecases.onboarding

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class OnboardingViewModel: DefaultLifecycleObserver {
    private val _uiEvents: MutableLiveData<UiEvent> = MutableLiveData()
    val uiEvents: LiveData<UiEvent> = _uiEvents

    fun onCreateApiKeyClicked() {
        _uiEvents.value = UiEvent.OpenUrl("https://circleci.com/account/api")
    }

    sealed class UiEvent {
        data class OpenUrl(val url: String): UiEvent()
    }
}