package com.pandacode.task.qupas.qupasomdb.network

import retrofit2.http.GET
import retrofit2.http.Query
import com.pandacode.task.qupas.qupasomdb.db.entity.Movie
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

// API KEY
const val APIKEY = "ec630e36"

//  url
//  http://www.omdbapi.com/?apikey=ec630e36&t=lego

interface ApiEndpoint {

    //get data
    @GET("/?apikey=ec630e36")
    fun getMovieData(@Query("t") t: String?) : Observable<Movie>

    companion object {

        val BASE_URL = "http://www.omdbapi.com"

        fun loadData(): ApiEndpoint {
            val requestInterface = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

            return requestInterface.create(ApiEndpoint::class.java)
        }

    }

}