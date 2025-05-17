package com.hiearth.fullquiz.core.local

import android.content.Context
import android.content.SharedPreferences
import com.hiearth.fullquiz.core.model.Interests

object SharedPreferenceManager {
    private const val PREFS_NAME = "my_prefs"
    private const val KEY_IS_LOGGED_IN = "is_logged_in"
    private const val KEY_NICKNAME = "nickname"
    private const val KEY_INTEREST = "interest"

    private fun getPrefs(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }


    // Login
    fun setLoggedIn(context: Context, isLoggedIn: Boolean) {
        getPrefs(context).edit()
            .putBoolean(KEY_IS_LOGGED_IN, isLoggedIn)
            .apply()
    }

    fun isLoggedIn(context: Context): Boolean {
        return getPrefs(context).getBoolean(KEY_IS_LOGGED_IN, false)
    }

    // Nickname
    fun setNickname(context: Context, nickname: String) {
        getPrefs(context).edit()
            .putString(KEY_NICKNAME, nickname)
            .apply()
    }

    fun getNickname(context: Context): String {
        return getPrefs(context).getString(KEY_NICKNAME, "") ?: ""
    }


    // Interest
    fun setInterest(context: Context, interest: Interests) {
        getPrefs(context).edit()
            .putString(KEY_INTEREST, interest.name)
            .apply()
    }

    fun getInterest(context: Context): Interests {
        val name = getPrefs(context).getString(KEY_INTEREST, null)
        return try {
            name?.let { Interests.valueOf(it) } ?: Interests.RECYCLE
        } catch (e: IllegalArgumentException) {
            Interests.RECYCLE
        }
    }


    fun clearAll(context: Context) {
        getPrefs(context).edit().clear().apply()
    }

}