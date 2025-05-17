package com.hiearth.fullquiz.core.local

import android.content.Context
import android.content.SharedPreferences
import com.hiearth.fullquiz.core.model.Interests

object SharedPreferenceManager {
    private const val PREFS_NAME = "my_prefs"
    private const val KEY_IS_LOGGED_IN = "is_logged_in"
    private const val KEY_NICKNAME = "nickname"
    private const val KEY_INTEREST = "interest"

    private lateinit var prefs: SharedPreferences

    fun init(context: Context) {
        prefs = context.applicationContext.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    // Login
    fun setLoggedIn(isLoggedIn: Boolean) {
        prefs.edit().putBoolean(KEY_IS_LOGGED_IN, isLoggedIn).apply()
    }

    fun isLoggedIn(): Boolean {
        return prefs.getBoolean(KEY_IS_LOGGED_IN, false)
    }

    // Nickname
    fun setNickname(nickname: String) {
        prefs.edit().putString(KEY_NICKNAME, nickname).apply()
    }

    fun getNickname(): String {
        return prefs.getString(KEY_NICKNAME, "") ?: ""
    }

    // Interest
    fun setInterest(interest: Interests) {
        prefs.edit().putString(KEY_INTEREST, interest.name).apply()
    }

    fun getInterest(): Interests {
        val name = prefs.getString(KEY_INTEREST, null)
        return try {
            name?.let { Interests.valueOf(it) } ?: Interests.RECYCLE
        } catch (e: IllegalArgumentException) {
            Interests.RECYCLE
        }
    }

    fun clearAll() {
        prefs.edit().clear().apply()
    }
}
