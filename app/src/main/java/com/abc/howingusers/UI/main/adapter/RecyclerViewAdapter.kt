package com.abc.howingusers.UI.main.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.abc.howingusers.Data.model.users
import com.abc.howingusers.R
import com.squareup.picasso.Picasso



class RecyclerViewAdapter(private val Users: ArrayList<users>) : RecyclerView.Adapter<RecyclerViewAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(user: users) {
            itemView.apply {

                //(val id: Int, val email: String, val firstName: String, val lastName: String, val avatar: String)

               val name = findViewById(R.id.name) as TextView
                val userID = findViewById(R.id.userID) as TextView
                val email = findViewById(R.id.email) as TextView
                val avatar = findViewById(R.id.imageView) as ImageView

                name.text = "Name: " + user.first_name + " " + user.last_name
                userID.text = "Id: " + user.userID.toString()
                email.text = "Email: " + user.email
                Picasso.get()
                        .load(user.avatar)
                        .into(avatar)





            }
        }
    }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
                DataViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false))

       override fun getItemCount(): Int = Users.size

        override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
            holder.bind(Users[position])
        }

        fun addUsers(Users: List<users>) {
            this.Users.apply {
                clear()
                addAll(Users)
            }
        }


    }




