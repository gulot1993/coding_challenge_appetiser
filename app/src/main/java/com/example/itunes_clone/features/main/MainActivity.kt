package com.example.itunes_clone.features.main

import android.os.Bundle
import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import com.example.itunes_clone.R
import com.example.itunes_clone.common.base.BaseViewModelActivity
import com.example.itunes_clone.databinding.ActivityMainBinding
import com.example.itunes_clone.databinding.FragmentMusicDetailBinding
import com.example.itunes_clone.domain.Music
import com.example.itunes_clone.ext.loadImage
import com.google.android.material.bottomsheet.BottomSheetDialog
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy

class MainActivity : BaseViewModelActivity<MainViewModel, ActivityMainBinding>(), MusicAdapter.OnItemListener {
    private val musicAdapter: MusicAdapter by lazy {
        return@lazy MusicAdapter()
    }
    private val gridLayoutManager: GridLayoutManager by lazy {
        return@lazy GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false)
    }
    override fun getLayoutId(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getMusicFromDb()
        setupVMObservers()
    }

    private fun setupRecyclerView() {
        binding
            .rvMusics
            .apply {
                this.adapter = musicAdapter
                musicAdapter.setItemListener(this@MainActivity)
                this.layoutManager = gridLayoutManager
                this.addItemDecoration(DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL))
            }
    }

    private fun setupVMObservers() {
        viewModel
            .state
            .observeOn(scheduler.main())
            .subscribeOn(scheduler.io())
            .subscribeBy(
                onNext = { state ->
                    handleState(state = state)
                },
                onError = { throwable ->
                    throwable.message?.let { message ->
                        showError(msg = message)
                    }
                }
            )
            .addTo(disposables)
    }

    private fun handleState(state: MainState) {
        when(state) {
            is MainState.GettingMusicError -> {
                state.msg?.let {
                    message -> showError(msg = message)
                }
            }
            is MainState.GettingMusicSuccess -> {
                setupRecyclerView()
                musicAdapter.setItems(items = state.musics)
            }
        }
    }

    override fun onItemClick(music: Music) {
        super.onItemClick(music)
        showBottomSheetDialog(music)
    }

    private fun showBottomSheetDialog(music: Music) {
        val bottomSheetDialog = BottomSheetDialog(this)
        val binding: FragmentMusicDetailBinding =
                DataBindingUtil.inflate(
                        LayoutInflater.from(this),
                        R.layout.fragment_music_detail,
                        null,
                        false
                )
        binding.music = music
        bottomSheetDialog.setContentView(binding.root)
        binding
            .ivMusic
            .loadImage(music.imageURL)
        bottomSheetDialog.show()
    }
}