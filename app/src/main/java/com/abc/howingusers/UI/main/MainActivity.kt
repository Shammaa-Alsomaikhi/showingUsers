package com.abc.howingusers.UI.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abc.howingusers.Data.users
import com.abc.howingusers.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        //getting recyclerview from xml
        val recyclerView = findViewById(R.id.recyclerView) as RecyclerView

        //adding a layoutmanager
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)


        //crating an arraylist to store users using the data class user
        val users = ArrayList<users>()

        //adding some dummy data to the list
        users.add(users(1 ,"a1@gmail.com", "Ranchi", "Jharkhand", "https://t4.ftcdn.net/jpg/02/45/28/17/360_F_245281783_3zeOLu7mhjUmYbFlBwSNsfwQmQZzukWo.jpg"))
        users.add(users(2,  "a2@gmail.com","Ranchi", "Jharkhand", "https://t4.ftcdn.net/jpg/02/45/28/17/360_F_245281783_3zeOLu7mhjUmYbFlBwSNsfwQmQZzukWo.jpg"))
        users.add(users(3, "a3@gmail.com","Ranchi", "Jharkhand", "https://t4.ftcdn.net/jpg/02/45/28/17/360_F_245281783_3zeOLu7mhjUmYbFlBwSNsfwQmQZzukWo.jpg"))
        users.add(users(4, "a4@gmail.com","Ranchi", "Jharkhand", "https://t4.ftcdn.net/jpg/02/45/28/17/360_F_245281783_3zeOLu7mhjUmYbFlBwSNsfwQmQZzukWo.jpg"))

        //creating our adapter
        val adapter = RecyclerViewAdapter(users)

        //now adding the adapter to recyclerview
        recyclerView.adapter = adapter
    }
}