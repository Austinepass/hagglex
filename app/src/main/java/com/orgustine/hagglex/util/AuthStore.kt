package com.orgustine.hagglex.util

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import com.orgustine.hagglex.ui.MainActivity

object AuthStore {
    private const val KEY_TOKEN = "TOKEN"
//    private fun preferences(context: Context): SharedPreferences {
//        val masterKeyAlias: String = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)
//
//        return EncryptedSharedPreferences.create(
//            "secret_shared_prefs",
//            masterKeyAlias,
//            context,
//            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
//            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
//        )
//    }
    fun preferences(context: Context): SharedPreferences = context.getSharedPreferences("pref",Context.MODE_PRIVATE)

    fun getToken(context: Context): String? {
        return preferences(context).getString(KEY_TOKEN, "")
    }

    fun setToken(context: Context, token: String) {
        preferences(context).edit().apply {
            putString(KEY_TOKEN, token)
            apply()
        }
    }

    fun removeToken(context: Context) {
        preferences(context).edit().apply {
            remove(KEY_TOKEN)
            apply()
        }
    }
}