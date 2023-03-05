package com.mobilelife.photogallery.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.mobilelife.photogallery.data.model.PicSum
import com.mobilelife.photogallery.domain.usecases.GetAllPicSumUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class PicSumViewModel @Inject constructor(private val getAllPicSumUsecase: GetAllPicSumUsecase) :
    ViewModel() {

    private val _selectedPicSum = MutableLiveData<PicSum>()

    fun fetchAllPicSums(): Flow<PagingData<PicSum>> {
        return getAllPicSumUsecase()
    }

    fun selectedPicSum(picSum: PicSum) {
        _selectedPicSum.value = picSum
    }

    fun getSelectedPicSum() = _selectedPicSum.value
}