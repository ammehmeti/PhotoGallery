package com.mobilelife.photogallery.domain.repository

import androidx.paging.PagingData
import com.mobilelife.photogallery.data.model.PicSum
import kotlinx.coroutines.flow.Flow

interface Repository {
    fun getAll(): Flow<PagingData<PicSum>>
}