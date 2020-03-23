package com.ardakazanci.dependencyinjectionwithkoin.utils


enum class Status {
    RUNNING,
    SUCCESS,
    FAILED
}

data class LoadingState private constructor(val status: Status, val msg: String? = null) {
    companion object {
        val LOADED = LoadingState(Status.SUCCESS)
        val LOADING = LoadingState(Status.RUNNING)
        fun error(msg: String?) = LoadingState(Status.FAILED, msg)
    }
}