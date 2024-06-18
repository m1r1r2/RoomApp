package com.littlelemon.roomapp.api


import com.littlelemon.roomapp.models.QuoteList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteServices {
    @GET("/quotes")
    suspend fun getquotes(@Query("page")page:Int): Response<QuoteList>
}