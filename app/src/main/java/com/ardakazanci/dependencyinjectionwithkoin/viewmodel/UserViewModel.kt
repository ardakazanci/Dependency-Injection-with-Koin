package com.ardakazanci.dependencyinjectionwithkoin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ardakazanci.dependencyinjectionwithkoin.data.model.User
import com.ardakazanci.dependencyinjectionwithkoin.repository.UserRepository
import com.ardakazanci.dependencyinjectionwithkoin.utils.LoadingState
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserViewModel(private val repository: UserRepository) : ViewModel(),Callback<List<User>> {

    private val _loadingState = MutableLiveData<LoadingState>()
    val loadingState: LiveData<LoadingState>
        get() = _loadingState

    private val _data = MutableLiveData<List<User>>()
    val data: LiveData<List<User>>
        get() = _data

    init {
        fetchData()
    }

    private fun fetchData(){
        _loadingState.postValue(LoadingState.LOADING)
        repository.getAllUsers().enqueue(this)
    }

    override fun onFailure(call: Call<List<User>>, t: Throwable) {
        _loadingState.postValue(LoadingState.error(t.message))
    }

    override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
        if (response.isSuccessful) {
            _data.postValue(response.body())
            _loadingState.postValue(LoadingState.LOADED)
        } else {
            _loadingState.postValue(LoadingState.error(response.errorBody().toString()))
        }
    }


}