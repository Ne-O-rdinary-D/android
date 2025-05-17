package com.hiearth.fullquiz.core.local.datasource

import android.content.Context
import android.content.SharedPreferences
import com.hiearth.fullquiz.core.model.Interests
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class PreferenceDataSourceImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : PreferenceDataSource {

    private val prefs: SharedPreferences by lazy {
        context.getSharedPreferences("my_prefs", Context.MODE_PRIVATE)
    }

    override fun setNickname(nickname: String) {
        prefs.edit().putString("nickname", nickname).apply()
    }

    override fun getNickname(): String {
        return prefs.getString("nickname", "") ?: ""
    }

    override fun setInterest(interest: Interests) {
        prefs.edit().putString("interest", interest.name).apply()
    }

    override fun getInterest(): Interests {
        val name = prefs.getString("interest", null)
        return try {
            name?.let { Interests.valueOf(it) } ?: Interests.RECYCLE
        } catch (_: IllegalArgumentException) {
            Interests.RECYCLE
        }
    }

    override fun clearAll() {
        prefs.edit().clear().apply()
    }
}