package com.mobilelife.photogallery.utils.imageloader

import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.mobilelife.photogallery.R

object ImageLoader {

    fun loadImage(
        view: View,
        url: String,
        imageView: ImageView,
        errorDrawable: Int = R.drawable.ic_error_24dp
    ) {
        Glide.with(view).load(url).error(errorDrawable)
            .into(imageView)
    }

    fun loadImage(
        fragment: Fragment,
        url: String,
        imageView: ImageView,
        errorDrawable: Int = R.drawable.ic_error_24dp
    ) {
        Glide.with(fragment).load(url).error(errorDrawable).into(imageView)
    }
}