package com.example.gbv_monitoring_tool

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class ConnectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_connect)

        var listView= findViewById<ListView>(R.id.listView)
        var list= mutableListOf<Model>()


        //adding images
        list.add(Model("Call police","",R.drawable.ic_baseline_local_police_24))
        list.add(Model("Contact chief","",R.drawable.ic_baseline_contacts_24))
        list.add(Model("Get help from certified professional","",R.drawable.ic_baseline_person_pin_24))


        listView.adapter=Adapter(this,R.layout.row,list)}}

