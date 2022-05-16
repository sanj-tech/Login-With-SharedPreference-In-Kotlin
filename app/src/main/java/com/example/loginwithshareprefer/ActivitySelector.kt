package com.example.loginwithshareprefer

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lis.testdemo.sharedPreference.AndroidSharedPreference

class ActivitySelector: AppCompatActivity() {
    lateinit var androidSharedPreference: AndroidSharedPreference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navigateToNext()
    }

    private fun navigateToNext() {
        androidSharedPreference = AndroidSharedPreference(this)
        val isAlreadyLogin = AndroidSharedPreference(this).getIsAlreadyLogin()
        if (isAlreadyLogin) {
            val intent = Intent(this, WelcomeAct::class.java)
            startActivity(intent)
        } else {
            var intent = Intent(
                this, MainActivity::class.java
            )
            startActivity(intent)
        }
    }
}
