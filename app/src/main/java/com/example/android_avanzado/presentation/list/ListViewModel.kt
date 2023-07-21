package com.example.android_avanzado.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android_avanzado.domain.model.HeroModel
import com.example.android_avanzado.domain.usecase.GetHeroListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(getHeroListUseCase: GetHeroListUseCase): ViewModel() {
    private val _dataList = MutableLiveData<List<HeroModel>>()
    val dataList: LiveData<List<HeroModel>> get() = _dataList

    fun getData() {
        _dataList.value = GetHeroListUseCase().invoke()
    }



}