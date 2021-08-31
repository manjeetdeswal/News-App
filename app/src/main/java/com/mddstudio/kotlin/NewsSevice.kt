package com.mddstudio.kotlin

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


//https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=f0d874c0055945979c5011325b7d7437
//https://newsapi.org/v2/everything?q=tesla&from=2021-04-05&sortBy=publishedAt&apiKey=f0d874c0055945979c5011325b7d7437
const val BASE_URl = "https://newsapi.org/"
const val API = "f0d874c0055945979c5011325b7d7437"

interface NewsINterface {
    @GET("v2/top-headlines?apiKey=$API")
    fun getheadline(@Query("country") country: String, @Query("page") page: Int): Call<News>
}
object NewsSevice{
    val newsindstance:NewsINterface
    init {
          val retrofit = Retrofit.Builder().baseUrl(BASE_URl)
              .addConverterFactory(GsonConverterFactory.create())
              .build()
        newsindstance=retrofit.create(NewsINterface::class.java)
    }

}