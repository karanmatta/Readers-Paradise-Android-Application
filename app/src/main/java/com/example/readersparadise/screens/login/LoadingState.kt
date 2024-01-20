package com.example.readersparadise.screens.login

import android.net.http.UrlRequest.Status

data class LoadingState (val state: Status, val message: String? = null){

    companion object{
        val IDLE = LoadingState(Status.IDLE)
        val LOADING = LoadingState(Status.LOADING)
        val SUCCESS = LoadingState(Status.SUCCESS)
        val FAILED = LoadingState(Status.FAILED)
    }



    enum class Status{

        SUCCESS,
        FAILED,
        LOADING,
        IDLE
    }



}
