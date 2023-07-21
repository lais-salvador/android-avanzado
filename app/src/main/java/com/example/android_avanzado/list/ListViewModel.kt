package com.example.android_avanzado.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android_avanzado.Model

class ListViewModel: ViewModel() {
    private val _dataList = MutableLiveData<List<Model>>()
    val dataList: LiveData<List<Model>> get() = _dataList

    fun getData() {
        _dataList.value = List<Model>(10){ Model.dummy() }
    }
}