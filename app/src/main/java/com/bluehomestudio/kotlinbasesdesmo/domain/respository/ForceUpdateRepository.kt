package com.bluehomestudio.kotlinbasesdesmo.domain.respository

import com.bluehomestudio.kotlinbasesdesmo.data.response.ForceUpdateResponse
import retrofit2.Response

interface ForceUpdateRepository{
    suspend fun  getCheckForceUpdate() : Response<ForceUpdateResponse>
}