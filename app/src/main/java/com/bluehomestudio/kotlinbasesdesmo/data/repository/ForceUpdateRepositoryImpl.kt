package com.bluehomestudio.kotlinbasesdesmo.data.repository

import com.bluehomestudio.kotlinbasesdesmo.core.base.BaseRepository
import com.bluehomestudio.kotlinbasesdesmo.data.api.ForceUpdateAPI
import com.bluehomestudio.kotlinbasesdesmo.data.response.ForceUpdateResponse
import com.bluehomestudio.kotlinbasesdesmo.domain.respository.ForceUpdateRepository
import io.reactivex.Observable
import retrofit2.Response

class ForceUpdateRepositoryImpl : BaseRepository() , ForceUpdateRepository {

    override suspend fun getCheckForceUpdate() : Response<ForceUpdateResponse> {
        val forceUpdateMock = ForceUpdateResponse(false , "not update yet")
        return network.mockedRequest(forceUpdateMock).create(ForceUpdateAPI::class.java).forceUpdate()
    }

}