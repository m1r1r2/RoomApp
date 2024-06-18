package com.littlelemon.roomapp

import android.app.Application
import com.littlelemon.roomapp.Repository.QuotesRepository
import com.littlelemon.roomapp.api.QuoteServices
import com.littlelemon.roomapp.api.RetrofitService
import com.littlelemon.roomapp.db.QuoteDatabase

class QuoteApplication  :Application(){

    lateinit var  quotesRepository: QuotesRepository

    override fun onCreate() {
        super.onCreate()
        intialize()
    }

    private fun intialize(){
        val quoteServices=RetrofitService.getInstance().create(QuoteServices::class.java)

        val database=QuoteDatabase.getDatabase(applicationContext)

        quotesRepository=QuotesRepository(quoteServices,database,applicationContext)
    }
}