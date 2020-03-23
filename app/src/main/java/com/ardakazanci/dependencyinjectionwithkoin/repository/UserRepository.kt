package com.ardakazanci.dependencyinjectionwithkoin.repository

import com.ardakazanci.dependencyinjectionwithkoin.data.network.GithubApi

class UserRepository(private val api: GithubApi) {

    fun getAllUsers() = api.getUsers()

}