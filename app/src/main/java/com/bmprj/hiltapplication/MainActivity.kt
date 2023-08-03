package com.bmprj.hiltapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var kriptoList : RecyclerView

    private lateinit var viewModel:MainViewModel
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel =ViewModelProvider(this@MainActivity)[MainViewModel::class.java]

        kriptoList = findViewById<RecyclerView>(R.id.recy)
        kriptoList.layoutManager=LinearLayoutManager(this)
        observerKripto()
    }

    private fun observerKripto(){
        viewModel.kripto.observe(this){
            kriptoList.adapter=Adapter(it)
        }
    }
}