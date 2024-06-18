package com.littlelemon.roomapp.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.littlelemon.roomapp.models.QuotesResults
import retrofit2.Response

@Dao
interface QuoteDao {

    @Insert
    suspend fun addquotes(quotes: List<QuotesResults>)

    @Query("Select * FROM quote")
    suspend fun getAllQuotes():List<QuotesResults>
}