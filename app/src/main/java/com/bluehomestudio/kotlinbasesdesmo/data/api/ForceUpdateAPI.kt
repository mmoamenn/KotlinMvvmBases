package com.bluehomestudio.kotlinbasesdesmo.data.api

import com.bluehomestudio.kotlinbasesdesmo.data.response.ForceUpdateResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface ForceUpdateAPI{

    @GET("/forceUpdate")
    fun forceUpdate(): Observable<ForceUpdateResponse>

}