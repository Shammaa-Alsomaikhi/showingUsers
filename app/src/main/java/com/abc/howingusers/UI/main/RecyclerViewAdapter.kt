package com.abc.howingusers.UI.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.abc.howingusers.Data.users
import com.abc.howingusers.R
import com.abc.howingusers.domain.MainViewModel

class RecyclerViewAdapter (val viewModel: MainViewModel, val arrayList: ArrayList<users>, val context: Context): RecyclerView.Adapter<RecyclerViewAdapter.NotesViewHolder>() {
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
            Toast.makeText(context,"List is empty", Toast.LENGTH_LONG).show()
        }else{

        }
        return arrayList.size
    }


    inner  class NotesViewHolder(private val binding: View) : RecyclerView.ViewHolder(binding) {



        fun bind(user: users){
         //val id: Int, val email: String, val firstName: String, val lastName: String, val avatar: String)
            val name: TextView = binding.findViewById(R.id.name)

           /* binding.name.text = user.firstName + user.lastName
            binding.userID.text = user.id
            binding.email.text = user.email */

        }

    }

}
