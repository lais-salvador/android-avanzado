package com.example.android_avanzado.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_avanzado.domain.model.HeroModel
import com.example.android_avanzado.domain.usecase.GetHeroDetailByIdUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class DetailViewModel(
    private val getHeroDetailByIdUseCase: GetHeroDetailByIdUseCase,
): ViewModel() {

    private val _heroModel = MutableLiveData<HeroModel>()
    val heroModel: LiveData<HeroModel> get() = _heroModel

    fun getHeroDetailById(id: String){
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {
                getHeroDetailByIdUseCase.invoke(id)
            }
            _heroModel.value = result
        }
    }
}