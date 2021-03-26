package com.lintangprayogo.simplecaching.ui.restaurant

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lintangprayogo.simplecaching.api.RestaurantApi
import com.lintangprayogo.simplecaching.model.Restaurant
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class RestaurantViewModel @Inject constructor(api: RestaurantApi) : ViewModel() {
    private val restaurantLiveData: MutableLiveData<List<Restaurant>> = MutableLiveData()
    val restaurants: LiveData<List<Restaurant>> = restaurantLiveData

    init {
        viewModelScope.launch {
            val restaurants = api.getRestaurants()
            delay(2000)
            restaurantLiveData.value = restaurants
        }
    }

}