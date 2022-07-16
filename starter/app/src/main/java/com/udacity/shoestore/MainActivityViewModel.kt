package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

//TODO: (10) Create a class that extends ViewModel
class MainActivityViewModel : ViewModel() {

    private val _shoeList = MutableLiveData<List<Shoe>>()
    val shoeList: LiveData<List<Shoe>>
        get() = _shoeList

    init {
        Timber.tag("MainActivityViewModel").i("MainActivityViewModel init()")
        initList()
    }

    override fun onCleared() {
        Timber.tag("MainActivityViewModel").i("MainActivityViewModel onCleared()")
        super.onCleared()
    }

    fun addNewShoe(name: String, size: Double, company: String, description: String) {
        Timber.tag("MainActivityViewModel").i("addNewShoe($name, $size, $company, $description)")
        _shoeList.value = _shoeList.value?.plus(
            Shoe(
                name,
                size,
                company,
                description
            )
        )
    }

    private fun initList() {
        _shoeList.value = listOf()
        for (i in 2 downTo 1) {
            addNewShoe("shoe #$i", 40.0, "company #$i", "this is the shoe #$i in list")
        }
    }
}