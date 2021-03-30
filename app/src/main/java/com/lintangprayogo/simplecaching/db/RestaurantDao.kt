package com.lintangprayogo.simplecaching.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.lintangprayogo.simplecaching.model.Restaurant
import kotlinx.coroutines.flow.Flow

@Dao
interface RestaurantDao {
    @Query("SELECT * FROM RESTAURANTS")
    fun getAllRestaurant(): Flow<List<Restaurant>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRestaurant(data: List<Restaurant>)

    @Query("DELETE FROM RESTAURANTS")
    suspend fun deleteAllRestaurant()
}