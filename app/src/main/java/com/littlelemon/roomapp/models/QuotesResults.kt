package com.littlelemon.roomapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quote")
data class QuotesResults(
    @PrimaryKey(autoGenerate = true)
    val quoteId:Int,
    val _id: String,
                         val  author: String,
                         val content: String,
                       )
