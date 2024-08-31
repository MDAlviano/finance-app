package com.alviano.app.finance.ViewModel

import androidx.lifecycle.ViewModel
import com.alviano.app.finance.Repository.MainRepository

class MainViewModel(val repository: MainRepository): ViewModel() {
    constructor():this(MainRepository())

    fun loadData()=repository.items

}