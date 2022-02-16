package com.digimaster.daylima.util.digicore.refresh

import com.digimaster.daylima.util.digicore.pref.JayaPref
import com.digimaster.daylima.util.digicore.pref.JayaPrefConstant
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import retrofit2.Call;

class TokenAuthenticator: Authenticator {
    override fun authenticate(route: Route?, response: Response): Request? {
        return if (response.code == 401) {
            val refreshDataService = AppRetrofit.refreshService

            val refreshCall: Call<RefreshTokenResponseModel> = refreshDataService.refreshToken()

            //make it as retrofit synchronous call
            val refreshResponse: retrofit2.Response<RefreshTokenResponseModel> = refreshCall.execute()

            if (refreshResponse.code() == 200) {
                val responseModel: RefreshTokenResponseModel? = refreshResponse.body()

                responseModel?.data?.token?.let {
                   JayaPref.saveString(
                       JayaPrefConstant.USER_TOKEN,
                        it
                    )
                }
                responseModel?.data?.refreshToken?.let {
                    JayaPref.saveString(JayaPrefConstant.USER_REFRESH_TOKEN,
                        it
                    )
                }

                response.request.newBuilder()
                    .header("Authorization", "Bearer "+responseModel?.data?.token)
                    .build()

            } else if (refreshResponse != null && refreshResponse.code() == 401) {
                // do logout
                null
            } else {
                null
            }
        } else {
            null
        }
    }
}