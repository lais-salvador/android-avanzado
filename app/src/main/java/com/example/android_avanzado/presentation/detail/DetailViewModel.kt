package com.example.android_avanzado.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_avanzado.domain.model.HeroModel
import com.example.android_avanzado.domain.model.LocationModel
import com.example.android_avanzado.domain.usecase.GetHeroDetailByIdUseCase
import com.example.android_avanzado.domain.usecase.GetLastLocationByIdUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class DetailViewModel(
    private val getHeroDetailByIdUseCase: GetHeroDetailByIdUseCase,
    private val getLastLocationByIdUseCase: GetLastLocationByIdUseCase
): ViewModel() {

    private val _heroModel = MutableLiveData<HeroModel>()
    val heroModel: LiveData<HeroModel> get() = _heroModel

    private val _location = MutableLiveData<LocationModel>()
    val location: LiveData<LocationModel> get() = _location

    fun getData(id: String){
        getHeroDetailById(id)
        getLastLocationById(id)
    }
    private fun getHeroDetailById(id: String) = viewModelScope.launch {
        try{
            val result = withContext(Dispatchers.IO) {
                getHeroDetailByIdUseCase.invoke(id)
            }
            _heroModel.value = result
        }catch (_:Throwable){ }
    }

    private fun getLastLocationById(id: String) = viewModelScope.launch {
        val result = withContext(Dispatchers.IO) {
            getLastLocationByIdUseCase.invoke(id)
        }
        _location.value = result
    }

}