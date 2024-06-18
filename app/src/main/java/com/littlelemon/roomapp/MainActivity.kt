package com.littlelemon.roomapp


import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.littlelemon.roomapp.viewmodel.MainViewModel
import com.littlelemon.roomapp.viewmodel.MainViewModelFactory


class MainActivity : AppCompatActivity() {

  lateinit var loginViewModel: MainViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      val  repository  =(application as QuoteApplication).quotesRepository

      loginViewModel=ViewModelProvider(this,MainViewModelFactory(repository)).get(MainViewModel::class.java)

      loginViewModel.quotes.observe(this, Observer{
          Toast.makeText(this@MainActivity,it.results.size.toString(),Toast.LENGTH_SHORT).show()

      })





    }
}