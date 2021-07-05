package com.dicoding.moviecatalog

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.moviecatalog.databinding.ActivityMainBinding
import com.dicoding.moviecatalog.pager.PagerAdapter


class MainActivity : AppCompatActivity() {

    private var _activityMainBinding: ActivityMainBinding? = null
    private val binding get() = _activityMainBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pagerAdapter = PagerAdapter(this, supportFragmentManager)
        binding.pagerMain.adapter = pagerAdapter
        binding.tabMain.setupWithViewPager(binding.pagerMain)
        supportActionBar?.hide()

        val btnMove = findViewById<ImageView>(R.id.btnMove)
        btnMove.setOnClickListener {
            val uri = Uri.parse("moviecatalog://favorite")
            startActivity(Intent(Intent.ACTION_VIEW, uri))
            }
    }
    override fun onDestroy() {
        super.onDestroy()
        _activityMainBinding = null
    }
}