package com.digimaster.daylima.data.repository


import com.digimaster.daylima.model.JobResponse
import com.digimaster.daylima.model.PostJob
import com.digimaster.daylima.model.PostJobResponse
import io.reactivex.Single
import retrofit2.http.Query

interface HomeRepository {

    fun getJobs(): Single<JobResponse>
    fun postJob(postJob: PostJob): Single<PostJobResponse>
}