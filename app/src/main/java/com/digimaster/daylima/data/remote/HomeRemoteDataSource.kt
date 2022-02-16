package com.digimaster.daylima.data.remote


import com.digimaster.daylima.model.JobResponse
import com.digimaster.daylima.model.PostJob
import com.digimaster.daylima.model.PostJobResponse
import io.reactivex.Single

interface HomeRemoteDataSource {
    fun getJobs():Single<JobResponse>
    fun postJob(postJob: PostJob):Single<PostJobResponse>
}