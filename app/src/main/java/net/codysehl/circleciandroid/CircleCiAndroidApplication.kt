package net.codysehl.circleciandroid

import android.app.Application
import net.codysehl.circleciandroid.network.CircleCiService
import net.codysehl.circleciandroid.persistence.user.UserCache
import net.codysehl.circleciandroid.persistence.user.UserRepository
import timber.log.Timber


class CircleCiAndroidApplication : Application() {
    lateinit var userRepository: UserRepository

    override fun onCreate() {
        Timber.plant(Timber.DebugTree())

        val circleCiService = CircleCiService.create()

        userRepository = UserRepository(
            circleCiService,
            UserCache(this)
        )

        super.onCreate()

    }
}