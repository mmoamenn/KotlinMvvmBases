package com.bluehomestudio.kotlinbasesdesmo.domain.usecase

import androidx.lifecycle.MutableLiveData
import com.bluehomestudio.kotlinbasesdesmo.core.base.BaseUseCase
import com.bluehomestudio.kotlinbasesdesmo.data.network.Data
import com.bluehomestudio.kotlinbasesdesmo.data.network.DataStatus
import com.bluehomestudio.kotlinbasesdesmo.data.mapper.toForceUpdate
import com.bluehomestudio.kotlinbasesdesmo.data.repository.ForceUpdateRepositoryImpl
import com.bluehomestudio.kotlinbasesdesmo.domain.model.ForceUpdate
import com.bluehomestudio.kotlinbasesdesmo.domain.respository.ForceUpdateRepository
import org.koin.core.KoinComponent
import org.koin.core.inject

class ForceUpdateUseCase : BaseUseCase() , KoinComponent {

    val forceUpdateLiveData : MutableLiveData<Data<ForceUpdate>> by inject()

    var forceUpdateRepository : ForceUpdateRepository  = ForceUpdateRepositoryImpl()

    fun checkForceUpdate(){
        forceUpdateLiveData.postValue(Data(DataStatus.SUCCESS , null))
        loadNetwork(forceUpdateRepository.getCheckForceUpdate(), {
            forceUpdateLiveData.postValue(Data(DataStatus.SUCCESS , data = it.toForceUpdate()))
        } , {
            forceUpdateLiveData.postValue(Data(DataStatus.ERROR , error = it))
        })
    }


}