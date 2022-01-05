package com.example.itunes_clone.ext

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.itunes_clone.R

fun ImageView.loadImage(url: String) {
    Glide
        .with(this.context)
        .load(url)
        .centerCrop()
        .placeholder(R.drawable.ic_music)
        .into(this)
}