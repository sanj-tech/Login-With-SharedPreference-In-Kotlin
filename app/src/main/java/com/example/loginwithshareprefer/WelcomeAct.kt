package com.example.loginwithshareprefer

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.lis.testdemo.sharedPreference.AndroidSharedPreference

class WelcomeAct() : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcomeact)


        var txtuser = findViewById<TextView>(R.id.txtUserName)
        var txtdesig = findViewById<TextView>(R.id.txtUserPass)
        sharedPreferences =
            applicationContext.getSharedPreferences("loginPrefer", Context.MODE_PRIVATE)
        txtuser.setText(sharedPreferences.getString("userName", "UserName"))
        txtdesig.setText(sharedPreferences.getString("userPassword", "UserPassword"))


        initView()

    }

    private fun initView() {
        var btnLogOut = findViewById<Button>(R.id.btlogout)
        btnLogOut.setOnClickListener({
            var user = findViewById<TextView>(R.id.txtUserName)
            var pass = findViewById<TextView>(R.id.txtUserPass)
            sharedPreferences =
                applicationContext.getSharedPreferences("loginPrefer", Context.MODE_PRIVATE)
            user.setText(sharedPreferences.getString("ghh", "jhjh"))
            pass.setText(sharedPreferences.getString("gjhgj", "gjg"))

            AndroidSharedPreference(this).setIsAlreadyLogin(false)
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        })
    }
}