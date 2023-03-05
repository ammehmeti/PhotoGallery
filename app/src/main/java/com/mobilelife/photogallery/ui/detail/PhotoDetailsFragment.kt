package com.mobilelife.photogallery.ui.detail
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.mobilelife.photogallery.databinding.FragmentPhotoDetailsBinding
import com.mobilelife.photogallery.ui.PicSumViewModel
import com.mobilelife.photogallery.utils.imageloader.ImageLoader
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class PhotoDetailsFragment : Fragment() {

    private lateinit var binding: FragmentPhotoDetailsBinding
    private val mPicSumViewModel: PicSumViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentPhotoDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val picSum = mPicSumViewModel.getSelectedPicSum()
        if (picSum != null) {
            binding.authorText.text = picSum.author
            ImageLoader.loadImage(this, picSum.download_url, binding.authorImage)
        }
    }

}