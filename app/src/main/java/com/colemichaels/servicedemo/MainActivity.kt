package com.colemichaels.servicedemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.colemichaels.servicedemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),
    View.OnClickListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.button.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val intent = Intent(this, MyService::class.java)
        startService(intent)
    }
}