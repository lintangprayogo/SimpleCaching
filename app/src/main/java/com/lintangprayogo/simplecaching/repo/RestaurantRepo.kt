package com.lintangprayogo.simplecaching.repo

import androidx.room.withTransaction
import com.lintangprayogo.simplecaching.api.RestaurantApi
import com.lintangprayogo.simplecaching.db.RestaurantDatabase
import com.lintangprayogo.simplecaching.util.networkBoundResource
import kotlinx.coroutines.delay
import javax.inject.Inject

class RestaurantRepo @Inject constructor(private val api: RestaurantApi, private val db: RestaurantDatabase) {

    private val restaurantDao = db.restaurantDao()

    fun getRestaurants() = networkBoundResource(
            query = {
                restaurantDao.getAllRestaurant()
            },
            fetch = {
                delay(2000)
                api.getRestaurants()
            },
            saveFetchResult = {
                db.withTransaction {
                    restaurantDao.deleteAllRestaurant()
                    restaurantDao.insertRestaurant(it)
                }
            }

    )

}