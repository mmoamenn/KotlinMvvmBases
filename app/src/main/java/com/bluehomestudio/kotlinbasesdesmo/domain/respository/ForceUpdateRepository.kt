package com.bluehomestudio.kotlinbasesdesmo.domain.respository

import com.bluehomestudio.kotlinbasesdesmo.data.response.ForceUpdateResponse
import io.reactivex.Observable

interface ForceUpdateRepository{
    fun getCheckForceUpdate() : Observable<ForceUpdateResponse>
}