package com.digimaster.daylima.data.repository


import com.digimaster.daylima.data.remote.HomeRemoteDataSource
import com.digimaster.daylima.model.JobResponse
import com.digimaster.daylima.model.PostJob
import com.digimaster.daylima.model.PostJobResponse
import io.reactivex.Single
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(private val remoteDataSource: HomeRemoteDataSource) :
    HomeRepository {


    override fun getJobs(): Single<JobResponse> {
        return remoteDataSource.getJobs()
    }

    override fun postJob(postJob: PostJob): Single<PostJobResponse> {
        return remoteDataSource.postJob(postJob)
    }
}