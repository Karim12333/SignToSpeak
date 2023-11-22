package com.mobilearchitects.signtospeak.ui.Retrofit
import android.widget.Toast
import androidx.compose.runtime.MutableState
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Response
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

class RetrofitApiService {
    val api: RetrofitApi by lazy {
        Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8000") // Replace with your base URL
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(RetrofitApi::class.java)
    }


}