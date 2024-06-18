package com.littlelemon.roomapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Room
import androidx.room.RoomDatabase
import com.littlelemon.roomapp.models.QuotesResults

@Database(entities = [QuotesResults::class], version = 1)
 abstract class QuoteDatabase  :RoomDatabase() {

     abstract  fun quoteDao():QuoteDao

     companion object{
         @Volatile
         private  var INSTANCE:QuoteDatabase?=null

         fun getDatabase(context: Context):QuoteDatabase{
             if(INSTANCE==null){
                 synchronized(this){
                     INSTANCE=Room.databaseBuilder(context,QuoteDatabase::class.java,"QuoteDB").build()

                 }

             }
             return INSTANCE!!;
         }
     }
}