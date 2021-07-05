package com.dicoding.moviecatalog.favorite

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.moviecatalog.favorite.databinding.ActivityFavoriteBinding
import com.dicoding.moviecatalog.favorite.di.favoriteModule
import com.dicoding.moviecatalog.favorite.pager.PagerAdapter
import org.koin.core.context.loadKoinModules

class FavoriteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFavoriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadKoinModules(favoriteModule)

        val pagerAdapter = PagerAdapter(this, supportFragmentManager)
        binding.pagerFavorite.adapter = pagerAdapter
        binding.tabFavorite.setupWithViewPager(binding.pagerFavorite)
        supportActionBar?.hide()
    }
}