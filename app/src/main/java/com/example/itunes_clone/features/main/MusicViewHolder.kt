package com.example.itunes_clone.features.main

import androidx.recyclerview.widget.RecyclerView
import com.example.itunes_clone.databinding.ItemMusicBinding
import com.example.itunes_clone.domain.Music
import com.example.itunes_clone.ext.loadImage

class MusicViewHolder(private val binding: ItemMusicBinding): RecyclerView.ViewHolder(binding.root) {
    var listener: MusicAdapter.OnItemListener? = null

    fun bind(data: Music) {
        binding.music = data
        loadImage(data)
        binding
            .root
            .setOnClickListener {
                listener?.onItemClick(data)
            }
    }

    private fun loadImage(data: Music) {
        binding
            .ivMusic
            .loadImage(data.imageURL)
    }
}