package com.example.myapplicatio

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicatio.databinding.ChatListItemBinding
import com.example.myapplicatio.models.ModelItemChat

class ChatListAdapter(val list:List<ModelItemChat>): RecyclerView.Adapter<ChatListAdapter.ChatListHolder>() {
    class ChatListHolder(val binding:ChatListItemBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatListHolder {

    }

    override fun getItemCount(): Int {
        return list.size

    }

    override fun onBindViewHolder(holder: ChatListHolder, position: Int) {
        holder.

    }
}