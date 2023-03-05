package com.mobilelife.photogallery.ui.gallery

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mobilelife.photogallery.data.model.PicSum
import com.mobilelife.photogallery.databinding.RowPicsumItemsBinding
import com.mobilelife.photogallery.utils.imageloader.ImageLoader

class PicSumAdapter(private val onItemClick: (picsum: PicSum) -> Unit) :
    PagingDataAdapter<PicSum, PicSumAdapter.PicSumViewHolder>(PICSUM_COMPARATOR) {

    private lateinit var binding: RowPicsumItemsBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PicSumViewHolder {
        binding = RowPicsumItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PicSumViewHolder(binding, onItemClick)
    }


    override fun onBindViewHolder(holder: PicSumViewHolder, position: Int) {
        val picsum = getItem(position)
        picsum?.let { (holder as PicSumViewHolder).bind(it) }
    }

    companion object {
        private val PICSUM_COMPARATOR = object : DiffUtil.ItemCallback<PicSum>() {
            override fun areItemsTheSame(oldItem: PicSum, newItem: PicSum): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: PicSum, newItem: PicSum): Boolean {
                return oldItem == newItem
            }
        }
    }


    class PicSumViewHolder(
        private val binding: RowPicsumItemsBinding,
        private val onItemClick: (picsum: PicSum) -> Unit,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(picsum: PicSum) {
            with(binding) {
                picsumAuthor.text = picsum.author
                ImageLoader.loadImage(root, picsum.download_url, picusmImage)
                picsumCard.setOnClickListener { onItemClick(picsum) }
            }
        }
    }

}