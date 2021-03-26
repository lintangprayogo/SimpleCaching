package com.lintangprayogo.simplecaching.ui.restaurant

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.lintangprayogo.simplecaching.databinding.ActivityRestaurantBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RestaurantActivity : AppCompatActivity() {
    private val restaurantViewModel: RestaurantViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityRestaurantBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val restaurantAdapter = RestaurantAdapter()
        binding.apply {
            recyclerView.adapter = restaurantAdapter
            recyclerView.layoutManager = LinearLayoutManager(this@RestaurantActivity)
        }

        restaurantViewModel.restaurants.observe(this) {
            restaurantAdapter.submitList(it)
        }
    }
}