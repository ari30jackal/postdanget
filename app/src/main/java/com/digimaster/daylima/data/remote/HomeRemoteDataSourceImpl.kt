package com.digimaster.daylima.data.remote

import com.digimaster.daylima.data.service.HomeService
import com.digimaster.daylima.model.JobResponse
import com.digimaster.daylima.model.PostJob
import com.digimaster.daylima.model.PostJobResponse

import io.reactivex.Single
import javax.inject.Inject

class HomeRemoteDataSourceImpl @Inject constructor(private val service: HomeService) :
    HomeRemoteDataSource {


    override fun getJobs(): Single<JobResponse> {
        return service.getJobs()
    }

    override fun postJob(postJob: PostJob): Single<PostJobResponse> {
        return service.postJobs(postJob)
    }

}