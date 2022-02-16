package com.digimaster.daylima.activity.tesngajar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.digimaster.daylima.adapter.JobAdapter
import com.digimaster.daylima.databinding.ActivityJobBinding
import com.digimaster.daylima.model.Data
import com.digimaster.daylima.model.PostJob
import com.digimaster.daylima.viewmodel.JobViewModel

class JobActivity : AppCompatActivity() {
    lateinit var binding: ActivityJobBinding
    private val adapter = JobAdapter()
    private val viewModel: JobViewModel by lazy {
        ViewModelProviders.of(this).get(JobViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJobBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val layoutManager = LinearLayoutManager(this)
        binding.rvHasil.layoutManager = layoutManager
        viewModel.getJob()
        binding.add.setOnClickListener {
            viewModel.postJob(PostJob("test", "test", 123))

        }
        setObserver()
    }

    private fun setObserver() {
        viewModel.listResponse().observe(this, Observer {
            binding.rvHasil.adapter = adapter
            Log.d("teser", "if22")
            adapter.initData(it.data as ArrayList<Data>)
        })
        viewModel.listPost().observe(this, Observer {
            viewModel.getJob()
        })
    }
}