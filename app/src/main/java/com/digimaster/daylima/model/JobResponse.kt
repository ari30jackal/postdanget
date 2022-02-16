package com.digimaster.daylima.model

data class JobResponse(
    val code: Int,
    val `data`: List<Data>,
    val status: String
)