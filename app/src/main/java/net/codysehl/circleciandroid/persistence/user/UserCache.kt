package net.codysehl.circleciandroid.persistence.user

import android.content.Context
import android.content.Context.MODE_PRIVATE
import net.codysehl.circleciandroid.persistence.SharedPreferencesWrapper

class UserCache(context: Context) {
    val sharedPreferences = SharedPreferencesWrapper(context.getSharedPreferences(SHARED_PREFS_NAME, MODE_PRIVATE))

    fun setApiKey(apiKey: String) = sharedPreferences.setString(API_KEY, apiKey)
    fun getApiKey() = sharedPreferences.getString(API_KEY)

    companion object {
        const val SHARED_PREFS_NAME = "USER_CACHE"

        const val API_KEY = "API_KEY"
    }
}