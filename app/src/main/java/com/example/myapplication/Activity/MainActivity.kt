package com.example.myapplication.Activity

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.Adapter.NearDoctorsAdapter
import com.example.myapplication.R
import com.example.myapplication.ViewModel.MainViewModel
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel=MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initNearByDoctor()

    }

    private fun initNearByDoctor() {
        binding.apply {
            progressBar.visibility= View.VISIBLE
            viewModel.loadDoctors().observe(this@MainActivity, Observer {
                topView.layoutManager=
                    LinearLayoutManager(this@MainActivity,LinearLayoutManager.VERTICAL,false)
                topView.adapter=NearDoctorsAdapter(it)
                progressBar.visibility=View.GONE
                
            })
        }
    }
}