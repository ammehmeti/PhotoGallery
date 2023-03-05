package com.mobilelife.photogallery.domain.usecases

import androidx.paging.PagingData
import com.mobilelife.photogallery.data.model.PicSum
import com.mobilelife.photogallery.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllPicSumUsecase @Inject constructor(private val repository: Repository) {
    operator fun invoke(): Flow<PagingData<PicSum>> {
        return repository.getAll()
    }
}