package com.bmprj.hiltapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject constructor(private val kriptoRepo:KriptoRepo): ViewModel(){

    private val kriptoEmitter = MutableLiveData<List<Kripto>>()
    val kripto : LiveData<List<Kripto>> = kriptoEmitter

    init{
        load()
    }

    private fun load(){
        kriptoEmitter.value = kriptoRepo.getKripto()
    }

}