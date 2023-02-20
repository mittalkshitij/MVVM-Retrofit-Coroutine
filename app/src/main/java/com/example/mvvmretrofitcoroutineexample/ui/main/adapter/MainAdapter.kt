package com.example.mvvmretrofitcoroutineexample.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvmretrofitcoroutineexample.R
import com.example.mvvmretrofitcoroutineexample.data.model.User


class MainAdapter(private val users : ArrayList<User>): RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    class DataViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        var textViewUserName : TextView = itemView.findViewById(R.id.textViewUserName)
        var textViewUserEmail : TextView = itemView.findViewById(R.id.textViewUserEmail)
        var imageViewAvatar : ImageView = itemView.findViewById(R.id.imageViewAvatar)

        fun bind(user: User){
            itemView.apply {

                textViewUserName.text = user.userName
                textViewUserEmail.text = user.userEmail
                Glide.with(imageViewAvatar.context)
                    .load(user.image)
                    .into(imageViewAvatar)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        return DataViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false))
    }

    override fun getItemCount():Int = users.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(users[position])
    }

    fun addUsers(users: List<User>) {
        this.users.apply {
            clear()
            addAll(users)
        }
    }
}