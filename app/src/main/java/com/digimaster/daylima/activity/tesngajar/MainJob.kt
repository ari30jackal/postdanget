package com.digimaster.daylima.activity.tesngajar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.digimaster.daylima.databinding.ActivityMainJobBinding
import com.digimaster.daylima.viewmodel.JobViewModel

class MainJob : AppCompatActivity() {
    lateinit var binding :ActivityMainJobBinding
    private val viewModel: JobViewModel by lazy {
        ViewModelProviders.of(this).get(JobViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainJobBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}