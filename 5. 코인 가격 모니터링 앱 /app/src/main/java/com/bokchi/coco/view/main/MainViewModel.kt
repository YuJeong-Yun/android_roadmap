package com.bokchi.coco.view.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.bokchi.coco.db.entity.InterestCoinEntity
import com.bokchi.coco.repository.DBRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val dbRepository = DBRepository()

    lateinit var selectedCoinList : LiveData<List<InterestCoinEntity>>

    // CoinListFragment
    fun getAllInterestCoinData() = viewModelScope.launch {
        val coinList = dbRepository.getAllInterestCoinData().asLiveData()
        selectedCoinList = coinList
    }

    fun updateInterestCoinData(interestCoinEntity: InterestCoinEntity) = viewModelScope.launch(Dispatchers.IO) {
        interestCoinEntity.selected = !interestCoinEntity.selected

        dbRepository.updateInterestCoinData(interestCoinEntity)

    }


    // PriceChangeFragment
}