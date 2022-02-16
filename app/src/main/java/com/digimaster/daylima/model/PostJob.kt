package com.digimaster.daylima.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PostJob(
    @SerializedName("jobName")
    @Expose
    val jobName: String,
    @SerializedName("jobDesc")
    @Expose
    val jobDesc: String,
    @SerializedName("jobSalary")
    @Expose
    val jobSalary:Int,
)