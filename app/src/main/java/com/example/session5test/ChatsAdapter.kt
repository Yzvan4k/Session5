package com.example.session5test

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.session5test.databinding.ChatItemBinding

class ChatsAdapter(val list: List<chatData> ): RecyclerView.Adapter<ChatsAdapter.ChatsHolder>() {
    class ChatsHolder(val chat:ChatItemBinding) :RecyclerView.ViewHolder(chat.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatsHolder {
        return ChatsHolder(ChatItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ChatsHolder, position: Int) {
        holder.chat.name.text = list[position].name
        holder.chat.NameLetter.text = list[position].letter
    }
}