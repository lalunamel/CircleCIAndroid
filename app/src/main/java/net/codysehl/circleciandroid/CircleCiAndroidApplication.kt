package net.codysehl.circleciandroid

import android.app.Application
import net.codysehl.circleciandroid.network.CircleCiService
import timber.log.Timber


class CircleCiAndroidApplication : Application() {
    lateinit var circleCiService: CircleCiService

    override fun onCreate() {
        Timber.plant(Timber.DebugTree())

        circleCiService = CircleCiService.create()

        super.onCreate()

    }
}