package net.codysehl.circleciandroid.usecases.onboarding.enterapikey

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import timber.log.Timber

class EnterApiKeyViewModel: DefaultLifecycleObserver {
    private val _uiEvents: MutableLiveData<UiEvent> = MutableLiveData()
    val uiEvents: LiveData<UiEvent> = _uiEvents

    fun onApiKeyTextChanged(text: CharSequence) {
        Timber.d(text.toString())
    }

    fun onSaveApiKeyClicked() {
        Timber.d("save clicked")
    }

    sealed class UiEvent {

    }
}