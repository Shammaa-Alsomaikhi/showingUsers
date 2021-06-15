package com.abc.howingusers.UI.main

import android.content.Context
import android.icu.number.NumberFormatter.with
import android.icu.number.NumberRangeFormatter.with
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.recyclerview.widget.RecyclerView
import com.abc.howingusers.Data.users
import com.abc.howingusers.R
import com.abc.howingusers.domain.MainViewModel
import com.squareup.picasso.Picasso


class RecyclerViewAdapter( val arrayList: ArrayList<users>): RecyclerView.Adapter<RecyclerViewAdapter.NotesViewHolder>()  {
    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): RecyclerViewAdapter.NotesViewHolder {
        var root = LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return NotesViewHolder(root)
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter.NotesViewHolder, position: Int) {
        holder.bind(arrayList.get(position))
    }

    override fun getItemCount(): Int {
        if(arrayList.size==0){
          //  Toast.makeText(this,"List is empty", Toast.LENGTH_LONG).show()
        }else{

        }
        return arrayList.size
    }


    inner  class NotesViewHolder(private val binding: View) : RecyclerView.ViewHolder(binding) {



        fun bind(user: users){
         //val id: Int, val email: String, val firstName: String, val lastName: String, val avatar: String)
            val name = binding.findViewById(R.id.name) as TextView
            val userID = binding.findViewById(R.id.userID) as TextView
            val email = binding.findViewById(R.id.email) as TextView
            val avatar = binding.findViewById(R.id.imageView) as ImageView


            name.text = "name: " + user.firstName + " " + user.lastName
            userID.text = "Id:" + user.userID.toString()
            email.text = "email: " + user.email

            Picasso.get()
            .load(user.avatar)
                   .resize(91,83)
                   .centerCrop()
                    .into(avatar)



        }
    }

}



