package com.littlelemon.roomapp.Repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.littlelemon.roomapp.api.QuoteServices
import com.littlelemon.roomapp.db.QuoteDatabase
import com.littlelemon.roomapp.models.QuoteList
import com.littlelemon.roomapp.utils.NetworkUtils

class QuotesRepository(
    private  val quoteServices: QuoteServices,
    private  val quoteDatabase: QuoteDatabase,
    private val applicationContext:Context

) {
    private val quotelivedata=MutableLiveData<QuoteList>()

    val quotes:LiveData<QuoteList>
        get() = quotelivedata

    suspend fun getQuotes(page:Int){
        if(NetworkUtils.isInternetAvailable(applicationContext)){
            val result=quoteServices.getquotes(page)
            if(result?.body()!=null){
                quoteDatabase.quoteDao().addquotes(result.body()!!.results)
                quotelivedata.postValue(result.body())
            }
        }
        else{
            val  quotes=quoteDatabase.quoteDao().getAllQuotes()
            val quoteList=QuoteList(1,1,1,1,1,quotes)
            quotelivedata.postValue(quoteList)
        }

    }
}