package com.example.loginwithshareprefer

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.LoginFilter.UsernameFilterGMail
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import com.lis.testdemo.sharedPreference.AndroidSharedPreference

class MainActivity : AppCompatActivity() {
    lateinit var androidSharedPreference: AndroidSharedPreference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()

    }

    private fun initView() {

        androidSharedPreference= AndroidSharedPreference(this)
        val btLogin = findViewById<Button>(R.id.btnLoigin)

        btLogin.setOnClickListener {
            val userName = findViewById<EditText>(R.id.etUserName)
            val userPassW = findViewById<EditText>(R.id.userPass)
            val chk = findViewById<CheckBox>(R.id.check)
            val name = userName.text.toString()
            val pass = userPassW.text.toString()
            if (chk.isChecked) {
                if (androidSharedPreference.getString("userName")!!.isNotEmpty()){
                if (!name.equals(androidSharedPreference.getString("userName"),true)) {
                    Toast.makeText(this, "Enter valid user name", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                if (!pass.equals(androidSharedPreference.getString("userPassword"),true)) {
                    Toast.makeText(this, "Enter valid user password", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }}

                androidSharedPreference.setIsAlreadyLogin(true)
                androidSharedPreference.setString("userName", name)
                androidSharedPreference.setString("userPassword", pass)

                Toast.makeText(this, "login $name,$pass", Toast.LENGTH_SHORT).show()
                var intent = Intent(
                    this, WelcomeAct::class.java
                )
                startActivity(intent)
            } else {
                Toast.makeText(this, "not maintaining user state", Toast.LENGTH_SHORT).show()

            }


        }
    }
        }



