package com.example.myapplication.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.Model.DoctorsModel
import com.example.myapplication.Repository.MainRepository

class MainViewModel() : ViewModel() {

    private val repository = MainRepository()

    fun loadDoctors():LiveData<MutableList<DoctorsModel>>{
        return repository.load()
    }
}