package com.digimaster.daylima.util.digicore.refresh

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.Call

interface RefreshService {
    @GET("/api/v1/token/refresh")
    fun refreshToken(): Call<RefreshTokenResponseModel>
}