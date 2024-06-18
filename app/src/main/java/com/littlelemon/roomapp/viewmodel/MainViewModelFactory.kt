package com.littlelemon.roomapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.littlelemon.roomapp.Repository.QuotesRepository

class MainViewModelFactory(private val repository: QuotesRepository) :ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel (repository) as T
    }
}