package com.mobilelife.photogallery.utils.imageloader

import android.content.Context
import android.util.Log
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule
import com.mobilelife.photogallery.BuildConfig

@GlideModule
class GlideModule : AppGlideModule() {
    @Override
    override fun applyOptions(context: Context, builder: GlideBuilder) {
        if (BuildConfig.DEBUG)
            builder.setLogLevel(Log.VERBOSE)
    }
}