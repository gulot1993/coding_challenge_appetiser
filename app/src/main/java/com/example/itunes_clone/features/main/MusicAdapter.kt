package com.example.itunes_clone.features.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.itunes_clone.databinding.ItemMusicBinding
import com.example.itunes_clone.domain.Music

class MusicAdapter: RecyclerView.Adapter<MusicViewHolder>() {
    private val items = mutableListOf<Music>()
    private var listener: OnItemListener? = null

    interface OnItemListener {
        fun onItemClick(music: Music) {}
    }

    fun setItemListener(listener: OnItemListener) {
        this.listener = listener
    }

    fun setItems(items: List<Music>) {
        if (this.items.isNotEmpty()) this.items.clear()
        this.items.addAll(items)
    }

    fun getItem(position: Int) = items[position]

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMusicBinding.inflate(inflater, parent, false)
        val viewHolder = MusicViewHolder(binding)
        viewHolder.listener = this.listener
        return viewHolder
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemCount(): Int = items.size
}