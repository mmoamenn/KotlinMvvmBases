package com.bluehomestudio.kotlinbasesdesmo.domain.usecase

import androidx.lifecycle.MutableLiveData
import com.bluehomestudio.kotlinbasesdesmo.core.base.BaseUseCase
import com.bluehomestudio.kotlinbasesdesmo.data.network.Data
import com.bluehomestudio.kotlinbasesdesmo.data.network.DataStatus
import com.bluehomestudio.kotlinbasesdesmo.data.mapper.toForceUpdate
import com.bluehomestudio.kotlinbasesdesmo.domain.model.ForceUpdate
import com.bluehomestudio.kotlinbasesdesmo.data.repository.ForceUpdateRepositoryImpl
import com.bluehomestudio.kotlinbasesdesmo.domain.respository.ForceUpdateRepository
import org.koin.core.inject

class ForceUpdateUseCase : BaseUseCase() {

    val forceUpdateLiveData = MutableLiveData<Data<ForceUpdate>>()

    private val forceUpdateRepository : ForceUpdateRepository by inject()

    fun checkForceUpdate(){
        loadNetwork(forceUpdateRepository.getCheckForceUpdate().doOnSubscribe {
            forceUpdateLiveData.postValue(Data(DataStatus.LOADING))
        } , {
            forceUpdateLiveData.postValue(Data(DataStatus.SUCCESS , data = it.toForceUpdate()))
        } , {
            forceUpdateLiveData.postValue(Data(DataStatus.ERROR , error = it))
        })
    }

}