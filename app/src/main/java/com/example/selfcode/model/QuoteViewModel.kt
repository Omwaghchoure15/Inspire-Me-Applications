package com.example.selfcode.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.selfcode.api.RetrofitInstance
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
class QuoteViewModel : ViewModel (){
    var quote by mutableStateOf<ZenQuote?>(null) //mvvm
        private set
    init {
        fetchQuote()
    }
    fun fetchQuote(){
        viewModelScope.launch {
            try {
                delay(200)

                val response = RetrofitInstance.api.getRandomQuote()
                quote = response.first()
            }catch (e : Exception){
                e.printStackTrace()
            }

        }
    }
}