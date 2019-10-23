package com.bluehomestudio.kotlinbasesdesmo.domain.usecase

import androidx.lifecycle.MutableLiveData
import com.bluehomestudio.kotlinbasesdesmo.core.base.BaseUseCase
import com.bluehomestudio.kotlinbasesdesmo.data.network.Data
import com.bluehomestudio.kotlinbasesdesmo.data.network.DataStatus
import com.bluehomestudio.kotlinbasesdesmo.data.mapper.toForceUpdate
import com.bluehomestudio.kotlinbasesdesmo.data.response.ForceUpdateResponse
import com.bluehomestudio.kotlinbasesdesmo.domain.model.ForceUpdate
import com.bluehomestudio.kotlinbasesdesmo.domain.respository.ForceUpdateRepository
import org.koin.core.KoinComponent
import org.koin.core.inject

class ForceUpdateUseCase : BaseUseCase< ForceUpdateResponse , BaseUseCase.NoCache , BaseUseCase.None>() , KoinComponent {

    val forceUpdateLiveData : MutableLiveData<Data<ForceUpdate>> by inject()

    val forceUpdateRepository : ForceUpdateRepository  by inject()

    override suspend fun run(params: None): ForceUpdateResponse = forceUpdateRepository.getCheckForceUpdate().body()!!

    override fun loading() {
        forceUpdateLiveData.postValue(Data(DataStatus.LOADING))
    }

    override fun onSuccess(result: ForceUpdateResponse) {
        forceUpdateLiveData.postValue(Data(DataStatus.SUCCESS , data = result.toForceUpdate()))
    }

    override fun failed(exception: Exception) {
        forceUpdateLiveData.postValue(Data(DataStatus.ERROR , error = exception))
    }



}