package com.mobilelife.photogallery.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "remote_keys")
data class RemoteKeys(
    @PrimaryKey
    val picsumId: String,
    val prevKey: Int?,
    val nextKey: Int?
)