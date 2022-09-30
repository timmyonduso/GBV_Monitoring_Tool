package com.example.gbv_monitoring_tool

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class SignUpActivity : AppCompatActivity() {
    var RegEmail: EditText? = null
    var RegPassword: EditText? = null
    var ConfirmPassword: EditText? = null
    var LoginHere: TextView? = null
    var Register: Button? = null
    var mAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        RegEmail = findViewById(R.id.inputemail)
        RegPassword = findViewById(R.id.inputpassword)
        ConfirmPassword = findViewById(R.id.confirm_password)
        LoginHere = findViewById(R.id.loginInstead)
        Register = findViewById(R.id.btn_signup)

        mAuth = FirebaseAuth.getInstance()

        Register!!.setOnClickListener {
            createUser()
        }
        LoginHere!!.setOnClickListener {
            startActivity(Intent(this,LoginActivity::class.java))
        }

    }

    fun createUser(){
        var email = RegEmail!!.text.toString().trim()
        var password = RegPassword!!.text.toString().trim()

        if (email.isEmpty()){
            RegEmail!!.setError("Email cannot be empty")
            RegEmail!!.requestFocus()
        }else if(password.isEmpty()){
            RegPassword!!.setError("Password cannot be empty")
            RegPassword!!.requestFocus()
        }else {
            mAuth!!.createUserWithEmailAndPassword(email,password).addOnCompleteListener{
                    task->
                if (task.isSuccessful){
                    Toast.makeText(this,"User registered successfully",
                        Toast.LENGTH_LONG).show()
                    startActivity(Intent(this,LoginActivity::class.java))
                }else{
                    Toast.makeText(this,"User registration failed",
                        Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}