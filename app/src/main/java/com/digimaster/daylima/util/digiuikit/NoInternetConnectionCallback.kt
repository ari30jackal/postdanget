package com.digimaster.daylima.util.digiuikit

interface NoInternetConnectionCallback {
    fun onConnectionTimeout(){}
    fun onRetry()
}