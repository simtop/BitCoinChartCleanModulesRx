package com.simtop.bitcoinapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.simtop.bitcoinapp.core.selectVisibility
import com.simtop.bitcoinapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Setting view binding for Fragments
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun setupToolbar(title: String, activate: Boolean) {
        binding.toolbar.title = title
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(activate)
    }

    fun showToolbar(show: Boolean) {
        binding.toolbar.selectVisibility(show)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}