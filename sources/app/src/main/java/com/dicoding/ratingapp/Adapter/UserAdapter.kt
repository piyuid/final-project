package com.dicoding.ratingapp.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.ratingapp.R
import com.dicoding.ratingapp.detail.User

class UserAdapter(private val userList : ArrayList<User>):RecyclerView.Adapter<UserAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.MyViewHolder {
        val itemview = LayoutInflater.from(parent.context).inflate(R.layout.list_profile,
        parent,false)

        return MyViewHolder(itemview)
    }

    override fun onBindViewHolder(holder: UserAdapter.MyViewHolder, position: Int) {

        val user : User = userList[position]
        holder.NamaLengkap.text = user.name_user
        holder.Komentar.text = user.address_user


    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

        public class MyViewHolder(itemview : View) :RecyclerView.ViewHolder(itemview){


            val NamaLengkap : TextView = itemView.findViewById(R.id.tvnamalengkap)
            val Komentar : TextView = itemView.findViewById(R.id.tvkomentar)



        }
}