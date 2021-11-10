package com.example.parsinglocaljsonfile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    lateinit var RV: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RV = findViewById(R.id.RV)
        RV.adapter = RecyclerViewAdapter(this, parse(R.assets.data))
        RV.layoutManager = LinearLayoutManager(this)
    }

    private fun parse(rawID: Int): Images {
        val objectArrayString: String = this.resources.openRawResource(rawID).bufferedReader().use { it.readText() }
        return Gson().fromJson(objectArrayString, Images::class.java)
    }
}