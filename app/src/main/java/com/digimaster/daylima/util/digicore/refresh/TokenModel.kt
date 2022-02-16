package com.digimaster.daylima.util.digicore.refresh

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class TokenModel (
    @SerializedName("token")
    @Expose
    val token: String,
    @SerializedName("refreshToken")
    @Expose
    val refreshToken: String
)
