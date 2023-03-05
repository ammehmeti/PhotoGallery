package com.mobilelife.photogallery.ui.gallery

import android.os.Bundle
import android.text.Layout.Directions
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobilelife.photogallery.data.model.PicSum
import com.mobilelife.photogallery.databinding.FragmentPhotoGalleryBinding
import com.mobilelife.photogallery.ui.PicSumViewModel

import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


@AndroidEntryPoint
class PhotoGalleryFragment : Fragment() {

    private lateinit var binding: FragmentPhotoGalleryBinding
    private lateinit var recyclerView: RecyclerView
    private val picSumViewModel: PicSumViewModel by activityViewModels()
    private lateinit var picSumAdapter: PicSumAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentPhotoGalleryBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = binding.recyclerView
        setUpRecyclerView()
        showList()
    }

    private fun setUpRecyclerView() {
        picSumAdapter = PicSumAdapter { onCardClicked(it) }

        recyclerView.apply {
            adapter = picSumAdapter
            adapter = picSumAdapter.withLoadStateHeaderAndFooter(
                header = PicSumLoadStateAdapter { picSumAdapter.retry() },
                footer = PicSumLoadStateAdapter { picSumAdapter.retry() }
            )
            layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }

    }

    private fun onCardClicked(picSum: PicSum) {
        picSumViewModel.selectedPicSum(picSum)
        findNavController().navigate(
            PhotoGalleryFragmentDirections.actionGalleryToDetail()
        )

    }

    private fun showList() {
        lifecycleScope.launch {
            picSumViewModel.fetchAllPicSums().collectLatest {
                picSumAdapter.submitData(it)
            }
        }
    }
}