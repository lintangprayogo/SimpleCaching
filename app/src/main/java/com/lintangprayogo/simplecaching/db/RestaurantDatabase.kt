package com.lintangprayogo.simplecaching.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.lintangprayogo.simplecaching.model.Restaurant

@Database(entities = [Restaurant::class], version = 1)
abstract class RestaurantDatabase : RoomDatabase() {
    abstract fun restaurantDao(): RestaurantDao
}