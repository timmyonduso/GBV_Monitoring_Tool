package com.example.gbv_monitoring_tool

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {

    var learnmore : CardView?= null
    var join : CardView?= null
    var divulge : CardView?= null
    var connect : CardView?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    learnmore = findViewById(R.id.btn1)
    join = findViewById(R.id.btn2)
    divulge = findViewById(R.id.btn3)
    connect = findViewById(R.id.btn4)


        learnmore!!.setOnClickListener {
            startActivity(Intent(this,LearnActivity::class.java))
        }

        join!!.setOnClickListener {
            startActivity(Intent(this,SignUpActivity::class.java))
        }

        divulge!!.setOnClickListener {
            startActivity(Intent(this,DivulgeActivity::class.java))
        }
        connect!!.setOnClickListener {
            startActivity(Intent(this,ConnectActivity::class.java))
        }

    }}