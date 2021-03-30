package com.lintangprayogo.simplecaching.ui.restaurant

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.lintangprayogo.simplecaching.databinding.ActivityRestaurantBinding
import com.lintangprayogo.simplecaching.util.Resource
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
            restaurantViewModel.restaurants.observe(this@RestaurantActivity) {
                restaurantAdapter.submitList(it.data)
                progressBar.isVisible = it is Resource.Loading && it.data.isNullOrEmpty()
                textViewError.isVisible = it is Resource.Error && it.data.isNullOrEmpty()
                textViewError.text = it.throwable?.localizedMessage
            }
        }


    }
}