package com.example.android_avanzado.presentation.detail

import android.content.Context
import android.location.Location
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_avanzado.R
import com.example.android_avanzado.domain.model.HeroModel
import com.example.android_avanzado.domain.model.LocationModel
import com.example.android_avanzado.domain.usecase.GetHeroDetailByIdUseCase
import com.example.android_avanzado.domain.usecase.GetLastLocationByIdUseCase
import com.keepcoding.androidavanzado.domain.usecase.GetDistanceFromHeroUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class DetailViewModel(
    private val context: Context,
    private val getHeroDetailByIdUseCase: GetHeroDetailByIdUseCase,
    private val getLastLocationByIdUseCase: GetLastLocationByIdUseCase,
    private val getDistanceFromHeroUseCase: GetDistanceFromHeroUseCase
): ViewModel() {

    private val _heroModel = MutableLiveData<HeroModel>()
    val heroModel: LiveData<HeroModel> get() = _heroModel

    private val _location = MutableLiveData<String>()
    val location: LiveData<String> get() = _location

    private var userLocation: LocationModel? = null
    private var heroLocation: LocationModel? = null

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
        heroLocation = result
        showLocation()
    }

    private fun showLocation() {
        //Unwrap
        userLocation?.let {userLocationSafe ->
            heroLocation?.let{heroLocationSafe ->
                 val distance = getDistanceFromHeroUseCase.invoke(
                    userLocationSafe,
                    heroLocationSafe
                )

                _location.value = context.getString(
                    R.string.user_location,
                    distance.toString()
                )
            }
        }
    }

    fun setUserLocation(lat: Double, long: Double){
        userLocation = LocationModel(latitude = lat, longitude = long)
        showLocation()
    }

}