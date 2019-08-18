package net.codysehl.circleciandroid.usecases.onboarding.enterapikey

import android.view.View
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*
import net.codysehl.circleciandroid.persistence.user.UserRepository
import timber.log.Timber

class EnterApiKeyViewModel(
    private val userRepository: UserRepository
): DefaultLifecycleObserver {

    private val _uiEvents: MutableLiveData<UiEvent> = MutableLiveData()
    val uiEvents: LiveData<UiEvent> = _uiEvents

    val enableFields = MutableLiveData<Boolean>()
    val saveButtonVisibility = MutableLiveData<Int>()
    val loadingSpinnerVisibility = MutableLiveData<Int>()

    private var viewModelJob = SupervisorJob()
    private var viewModelScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    override fun onDestroy(owner: LifecycleOwner) = viewModelJob.cancel()

    private var apiKey: String = ""

    init {
        enableFields.value = true
        saveButtonVisibility.value = View.VISIBLE
        loadingSpinnerVisibility.value = View.GONE
    }

    fun onApiKeyTextChanged(text: CharSequence) {
        apiKey = text.toString()
    }

    fun onSaveApiKeyClicked() {
        enableFields.value = false
        saveButtonVisibility.value = View.INVISIBLE
        loadingSpinnerVisibility.value = View.VISIBLE

        viewModelScope.launch(Dispatchers.IO) {
            val user = userRepository.getUser(apiKey)

            launch(Dispatchers.Main) {
                if(user == null) {
                    _uiEvents.value = UiEvent.ShowInvalidApiKeyMessage
                }

                saveButtonVisibility.value = View.VISIBLE
                loadingSpinnerVisibility.value = View.GONE
                enableFields.value = true
            }
        }
    }

    sealed class UiEvent {
        object ShowInvalidApiKeyMessage: UiEvent()
    }
}