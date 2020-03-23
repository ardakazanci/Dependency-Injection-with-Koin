package com.ardakazanci.dependencyinjectionwithkoin.data.network

import com.ardakazanci.dependencyinjectionwithkoin.data.model.User
import retrofit2.Call
import retrofit2.http.GET

interface GithubApi {

    @GET("User")
    fun getUsers(): Call<List<User>>

}