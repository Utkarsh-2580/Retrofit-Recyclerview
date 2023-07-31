package com.example.retrofit

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var linearLayoutManager : LinearLayoutManager = LinearLayoutManager(this)
        recycler_view.layoutManager = linearLayoutManager



        val retrofitobj = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .build()
            .create(Myapiinterface::class.java)

        val retro = retrofitobj.getData()

        retro.enqueue(object : Callback<List<MydataItem>?> {
            override fun onResponse(
                call: Call<List<MydataItem>?>,
                response: Response<List<MydataItem>?>
            ) {

                val responsebody = response.body()!!

                val responseadapter : ResponseAdapter =  ResponseAdapter(baseContext,
                    responsebody as ArrayList<MydataItem>
                )

                recycler_view.adapter = responseadapter


            }

            override fun onFailure(call: Call<List<MydataItem>?>, t: Throwable) {

            }
        })

    }
}