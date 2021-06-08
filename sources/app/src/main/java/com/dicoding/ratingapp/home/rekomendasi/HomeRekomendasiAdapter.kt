package com.dicoding.ratingapp.home.rekomendasi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.ratingapp.R
import com.dicoding.ratingapp.model.dummy.HomeModel
import kotlinx.android.synthetic.main.item_home_vertical.view.*

class HomeRekomendasiAdapter(private val listData : List<HomeModel>, private val itemAdapterCallback : ItemAdapterCallback) : RecyclerView.Adapter<HomeRekomendasiAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ViewHolder{
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_home_vertical, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        holder.bind(listData[position], itemAdapterCallback)
    }

    override fun getItemCount(): Int{
        return listData.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(data: HomeModel, itemAdapterCallback: ItemAdapterCallback){
            itemView.apply{
                tvTitle.text = data.title
                tvAlamat.text = data.title
                rbApp.rating = data.rating

                Glide.with(context)
                    .load(data.src)
                itemView.setOnClickListener { itemAdapterCallback.onClick(it, data) }
            }
        }
    }

    interface ItemAdapterCallback{
        fun onClick(v: View, data: HomeModel)
    }
}