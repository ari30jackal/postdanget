package com.digimaster.daylima.util.digicore.refresh

import com.digimaster.daylima.util.digicore.pref.JayaPref
import com.digimaster.daylima.util.digicore.pref.JayaPrefConstant
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object AppRetrofit {
    const val BASE_URL = "BuildConfig.BASE_URL"

    val refreshClient: Retrofit.Builder by lazy{
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        val client: OkHttpClient = OkHttpClient.Builder()
            .readTimeout(120, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(Interceptor { chain: Interceptor.Chain ->
                val original: Request = chain.request()
                val request: Request =
                    original.newBuilder()
                        .header("Authorization", "Refresh "+
                                JayaPref.loadString(JayaPrefConstant.USER_REFRESH_TOKEN, ""))
                        .method(original.method, original.body)
                        .build()
                chain.proceed(request)
            })
            .addInterceptor(logging)
            .build()

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
    }

    val refreshService: RefreshService by lazy {
        refreshClient
            .build()
            .create(RefreshService::class.java)
    }
}