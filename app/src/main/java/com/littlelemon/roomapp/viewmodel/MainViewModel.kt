package com.littlelemon.roomapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.littlelemon.roomapp.Repository.QuotesRepository
import com.littlelemon.roomapp.models.QuoteList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel( private  val repository: QuotesRepository):ViewModel() {
    init {
        viewModelScope.launch(Dispatchers.IO) {
        repository.getQuotes(1)
        }
    }

    val quotes:LiveData<QuoteList>
        get() = repository.quotes
}