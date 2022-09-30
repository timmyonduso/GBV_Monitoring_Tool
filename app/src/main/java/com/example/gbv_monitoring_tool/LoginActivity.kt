package com.example.gbv_monitoring_tool

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    var LoginEmail: EditText? = null
    var LoginPassword: EditText? = null
    var Registerhere: TextView? = null
    var buttonlogin: Button? = null
    var mAuth: FirebaseAuth? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        LoginEmail = findViewById(R.id.inputemail)
        LoginPassword = findViewById(R.id.inputpassword)
        Registerhere = findViewById(R.id.gotoRegister)
        buttonlogin = findViewById(R.id.btn_login)

        mAuth = FirebaseAuth.getInstance()

        buttonlogin!!.setOnClickListener {
            LoginUser()
        }
        Registerhere!!.setOnClickListener {
            startActivity(Intent(this,SignUpActivity::class.java))
        }

    }

    fun LoginUser(){
        var email = LoginEmail!!.text.toString().trim()
        var password = LoginPassword!!.text.toString().trim()

        if (email.isEmpty()){
            LoginEmail!!.error = "Email cannot be empty"
            LoginEmail!!.requestFocus()
        }else if(password.isEmpty()){
            LoginPassword!!.error = "Password cannot be empty"
            LoginPassword!!.requestFocus()
        }else {
            mAuth!!.signInWithEmailAndPassword(email,password).addOnCompleteListener{
                    task->
                if (task.isSuccessful){
                    Toast.makeText(this,"User logged in successfully",
                        Toast.LENGTH_LONG).show()
                    startActivity(Intent(this,MainActivity::class.java))
                }else{
                    Toast.makeText(this,"User log in failed",
                        Toast.LENGTH_LONG).show()
                }
            }
        }

    }
}