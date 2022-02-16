package com.digimaster.daylima.data.service

import com.digimaster.daylima.model.JobResponse
import com.digimaster.daylima.model.PostJob
import com.digimaster.daylima.model.PostJobResponse
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query


interface HomeService {

    @GET("/api/v1/jobs")
    fun getJobs():Single<JobResponse>
    @POST("api/v1/job/body")
    fun postJobs(@Body postjob:PostJob):Single<PostJobResponse>
}