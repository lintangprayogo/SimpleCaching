package com.lintangprayogo.simplecaching.api

import com.lintangprayogo.simplecaching.model.Restaurant
import retrofit2.http.GET

interface RestaurantApi {
    companion object {
        val BASE_URL: String = "https://random-data-api.com/api/"
    }

    @GET("restaurant/random_restaurant?size=20")
    suspend fun getRestaurants(): List<Restaurant>
}