package com.example.cce_weatherstaion_demo

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val ret = Retrofit.Builder().baseUrl("http://10.0.2.2:8000/api/").addConverterFactory(GsonConverterFactory.create()).build()
        val server = ret.create(Server::class.java)
        val callPM10 = server.getPM10()
        val callAmbient : Call<Model> = server.getAmbient();

        callPM10.enqueue(object : Callback<Model>{
            override fun onFailure(call: Call<Model>, t: Throwable) {
                Log.e("Error" , t.toString())
            }

            override fun onResponse(call: Call<Model>, response: Response<Model>) {
                val res = response.body()!!
                PM10.text = ("PM10 : ${res.PM10}")
            }

        })

        callAmbient.enqueue(object : Callback<Model>{
            override fun onFailure(call: Call<Model>, t: Throwable) {
                Log.e("Error" , t.toString())
            }

            override fun onResponse(call: Call<Model>, response: Response<Model>) {
                val res = response.body()!!
                temperature.text = ("temperature : ${res.Temperature}")
                Humidity.text = ("Humidity : ${res.Humidity}")
                UV.text = ("UV : ${res.UV}")
                Solar.text = ("Solar : ${res.Solar}")
                Pressure.text = ("Pressure : ${res.Pressure}")
                Rain.text = ("Rain : ${res.Rain}")
                Wind_Direction.text = ("Wind_Direction : ${res.Wind_Direction}")
                Wind.text = ("Wind : ${res.Wind}")
            }

        })

    }
}
