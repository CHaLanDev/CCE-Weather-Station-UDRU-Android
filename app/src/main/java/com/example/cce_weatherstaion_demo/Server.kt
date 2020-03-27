package com.example.cce_weatherstaion_demo

import retrofit2.Call
import retrofit2.http.GET

interface Server {
    @GET(value = "datadustdtec")
    fun getPM10() : Call<Model>

    @GET(value = "dataambient")
    fun getAmbient() : Call<Model>

}