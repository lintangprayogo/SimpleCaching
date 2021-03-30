package com.lintangprayogo.simplecaching.ui.restaurant

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.lintangprayogo.simplecaching.repo.RestaurantRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class RestaurantViewModel @Inject constructor(repo: RestaurantRepo) : ViewModel() {

    val restaurants = repo.getRestaurants().asLiveData()


}