package net.codysehl.circleciandroid.usecases.onboarding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import net.codysehl.circleciandroid.CircleCiAndroidApplication
import net.codysehl.circleciandroid.R
import timber.log.Timber

class Onboarding : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        val application = application as CircleCiAndroidApplication

        lifecycleScope.launch {
            val me = application.circleCiService.me("")
            Timber.d("me: $me")
        }

    }
}
