package com.digimaster.daylima.util.digicore.refresh

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RefreshTokenResponseModel (
    @SerializedName("code")
    @Expose
    val code: Int,
    @SerializedName("status")
    @Expose
    val status: String,
    @SerializedName("data")
    @Expose
    val data: TokenModel
)

