package net.codysehl.circleciandroid.persistence.user

import net.codysehl.circleciandroid.models.SignedInUser
import net.codysehl.circleciandroid.network.CircleCiService
import timber.log.Timber

class UserRepository(
    private val circleCiService: CircleCiService,
    private val userCache: UserCache
) {
    suspend fun getUser(apiKey: String): SignedInUser? {
        return try {
            circleCiService.me(apiKey)
        } catch (e: Throwable) {
            Timber.e(e)
            null
        }
    }
}