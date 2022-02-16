package com.digimaster.daylima.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.digimaster.daylima.data.di.DaggerHomeComponent
import com.digimaster.daylima.data.repository.HomeRepository
import com.digimaster.daylima.model.JobResponse
import com.digimaster.daylima.model.PostJob
import com.digimaster.daylima.model.PostJobResponse
import com.google.gson.Gson
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import retrofit2.HttpException
import javax.inject.Inject

class JobViewModel: ViewModel() {
    private val list = MutableLiveData<JobResponse>()
    private val responsepost = MutableLiveData<PostJobResponse>()
    private val compositeDisposable = CompositeDisposable()
    private val isError = MutableLiveData<Boolean>()



    @Inject
    lateinit var repository: HomeRepository

    init {
       DaggerHomeComponent.create().injectJob(this)
    }


    fun getJob(){
        compositeDisposable.add(
            repository.getJobs()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<JobResponse>() {
                    override fun onSuccess(t:JobResponse) {
                        if (t.code == 200) {
                            list.value = t
                            Log.d("test123", "gaerror =  " + t.toString())
                        } else {
                            isError.value = true

                        }
                    }

                    override fun onError(e: Throwable) {
                        Log.d("test123", "error =  " + e.toString())
                        isError.value = true
                        if (e is HttpException) {
                            val errorBody = (e as HttpException).response()?.errorBody()
                            val gson = Gson()
                            val error = gson.fromJson(
                                errorBody?.string(),
                                JobResponse::class.java
                            )
                            Log.d("test123", "error =  " + error)

                        }
                    }
                })
        )
    }

    fun postJob(postJob: PostJob){
        compositeDisposable.add(
            repository.postJob(postJob)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<PostJobResponse>() {
                    override fun onSuccess(t:PostJobResponse) {
                        if (t.code == 200) {
                            responsepost.value = t
                            Log.d("test123", "gaerror =  " + t.toString())
                        } else {
                            isError.value = true

                        }
                    }

                    override fun onError(e: Throwable) {
                        Log.d("test123", "error =  " + e.toString())
                        isError.value = true
                        if (e is HttpException) {
                            val errorBody = (e as HttpException).response()?.errorBody()
                            val gson = Gson()
                            val error = gson.fromJson(
                                errorBody?.string(),
                                PostJobResponse::class.java
                            )
                            Log.d("test123", "error =  " + error)

                        }
                    }
                })
        )
    }

    fun listResponse(): MutableLiveData<JobResponse> {
        return list
    }
    fun listPost():MutableLiveData<PostJobResponse>
    {
        return responsepost
    }


    fun getIsError(): MutableLiveData<Boolean> {
        return isError
    }
}