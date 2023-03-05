package com.mobilelife.photogallery.data.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mobilelife.photogallery.data.model.PicSum

@Dao
interface PicSumDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(list: List<PicSum>)

    @Query("SELECT * FROM picsum")
    fun getAll(): PagingSource<Int, PicSum>

    @Query("DELETE FROM picsum")
    suspend fun clearAll()
}