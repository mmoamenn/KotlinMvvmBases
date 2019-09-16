package com.bluehomestudio.kotlinbasesdesmo.ui

import androidx.lifecycle.MutableLiveData
import com.bluehomestudio.kotlinbasesdesmo.core.base.BaseViewModel
import com.bluehomestudio.kotlinbasesdesmo.domain.model.ForceUpdate
import com.bluehomestudio.kotlinbasesdesmo.domain.usecase.ForceUpdateUseCase
import org.koin.core.inject

class MainViewModel(var forceUpdateUseCase : ForceUpdateUseCase )  : BaseViewModel() {

    val forceUpdateLiveData = forceUpdateUseCase.forceUpdateLiveData

    fun checkForceUpdate(){
        forceUpdateUseCase.checkForceUpdate()
    }


}