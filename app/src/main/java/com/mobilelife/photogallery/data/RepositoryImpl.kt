package com.mobilelife.photogallery.data


import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.mobilelife.photogallery.data.local.PicSumDatabase
import com.mobilelife.photogallery.data.model.PicSum
import com.mobilelife.photogallery.data.remote.PicSumService
import com.mobilelife.photogallery.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

public const val PAGE_SIZE = 20

class RepositoryImpl @Inject constructor(
    private val service: PicSumService,
    private val database: PicSumDatabase
) : Repository {
    override fun getAll(): Flow<PagingData<PicSum>> {
        /*
        // for paging source
         @OptIn(ExperimentalPagingApi::class)
         return Pager(
             config = PagingConfig(pageSize = PAGE_SIZE, enablePlaceholders = false),
             pagingSourceFactory = { PicSumPagingSource(service) }
         ).flow*/

        @OptIn(ExperimentalPagingApi::class)
        return Pager(
            config = PagingConfig(pageSize = PAGE_SIZE, enablePlaceholders = false),
            remoteMediator = PicSumRemoteMediator(
                service,
                database
            ),
            pagingSourceFactory = { database.picSumDao().getAll() }
        ).flow
    }


}