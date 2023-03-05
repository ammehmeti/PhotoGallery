package com.mobilelife.photogallery.ui.gallery

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mobilelife.photogallery.R
import com.mobilelife.photogallery.databinding.LayoutLoadStateViewItemBinding

class PicSumLoadStateAdapter(private val retry: () -> Unit
) : LoadStateAdapter<PicSumLoadStateAdapter.PicSumLoadStateViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): PicSumLoadStateViewHolder {
        return PicSumLoadStateViewHolder.create(parent, retry)
    }

    override fun onBindViewHolder(holder: PicSumLoadStateViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }




    class PicSumLoadStateViewHolder(
        private val binding: LayoutLoadStateViewItemBinding,
        retry: () -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.retryButton.setOnClickListener { retry.invoke() }
        }

        fun bind(loadState: LoadState) {
            if (loadState is LoadState.Error) {
                binding.errorMessage.text = loadState.error.localizedMessage
            }
            binding.progressBar.isVisible = loadState is LoadState.Loading
            binding.retryButton.isVisible = loadState is LoadState.Error
            binding.errorMessage.isVisible = loadState is LoadState.Error
        }

        companion object {
            fun create(parent: ViewGroup, retry: () -> Unit): PicSumLoadStateViewHolder {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.layout_load_state_view_item, parent, false)
                val binding = LayoutLoadStateViewItemBinding.bind(view)
                return PicSumLoadStateViewHolder(binding, retry)
            }
        }
    }
}