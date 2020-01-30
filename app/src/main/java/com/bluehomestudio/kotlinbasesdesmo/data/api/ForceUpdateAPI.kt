package com.bluehomestudio.kotlinbasesdesmo.data.api

import com.bluehomestudio.kotlinbasesdesmo.data.response.ForceUpdateResponse
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET

interface ForceUpdateAPI{

    @GET("/forceUpdate")
    suspend fun  forceUpdate(): ForceUpdateResponse

}