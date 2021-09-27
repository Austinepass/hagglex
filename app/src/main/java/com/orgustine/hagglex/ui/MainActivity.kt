package com.orgustine.hagglex.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.orgustine.hagglex.R
import com.orgustine.hagglex.util.AuthStore

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        Log.i("MainAc", AuthStore.getToken(this)!!)
    }
}