package com.example.githubuser

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.githubuser.databinding.ItemRowUserBinding

class ListUserAdapter(private val listUser: ArrayList<User>) :
    RecyclerView.Adapter<ListUserAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemCallback
    }

    class ListViewHolder(var binding: ItemRowUserBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, avatar, location, company) = listUser[position]
        Glide.with(holder.itemView.context)
            .load(avatar)
            .into(holder.binding.imgItemAvatar)
        holder.binding.tvItemName.text = name
        holder.binding.tvItemLocation.text = location
        holder.binding.tvItemCompany.text = company

        Log.d("Data Location", holder.binding.tvItemCompany.text.toString())

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listUser[holder.adapterPosition])
        }
    }

    override fun getItemCount() = listUser.size

    interface OnItemClickCallback {
        fun onItemClicked(data: User)
    }
}