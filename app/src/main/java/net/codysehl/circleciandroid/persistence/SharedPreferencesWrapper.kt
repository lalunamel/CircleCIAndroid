package net.codysehl.circleciandroid.persistence

import android.content.SharedPreferences
import androidx.core.content.edit

class SharedPreferencesWrapper(private val sharedPreferences: SharedPreferences) {
    fun contains(key: String): Boolean = sharedPreferences.contains(key)

    fun getBoolean(key: String): Boolean = sharedPreferences.getBoolean(key, false)
    fun getFloat(key: String): Float = sharedPreferences.getFloat(key, 0f)
    fun getInt(key: String): Int = sharedPreferences.getInt(key, 0)
    fun getLong(key: String): Long = sharedPreferences.getLong(key, 0)
    fun getString(key: String): String? = sharedPreferences.getString(key, null)
    fun getStringSet(key: String): Set<String>? = sharedPreferences.getStringSet(key, null)

    fun setBoolean(key: String, value: Boolean) = sharedPreferences.edit { putBoolean(key, value) }
    fun setFloat(key: String, value: Float) = sharedPreferences.edit { putFloat(key, value) }
    fun setInt(key: String, value: Int) = sharedPreferences.edit { putInt(key, value) }
    fun setLong(key: String, value: Long) = sharedPreferences.edit { putLong(key, value) }
    fun setString(key: String, value: String) = sharedPreferences.edit { putString(key, value) }
    fun setStringSet(key: String, value: Set<String>) = sharedPreferences.edit { putStringSet(key, value) }

    fun remove(key: String) = sharedPreferences.edit { remove(key) }
}