package com.example.android_avanzado.list

import androidx.lifecycle.ViewModel
import com.example.android_avanzado.Model

class ListViewModel: ViewModel() {
    fun getData() = List<Model>(10){ Model.dummy() }
}