package com.bluehomestudio.kotlinbasesdesmo.ui

import com.bluehomestudio.kotlinbasesdesmo.core.base.BaseViewModel
import com.bluehomestudio.kotlinbasesdesmo.domain.usecase.ForceUpdateUseCase

class MainViewModel(var forceUpdateUseCase : ForceUpdateUseCase )  : BaseViewModel() {

    val forceUpdateLiveData = forceUpdateUseCase.forceUpdateLiveData

    fun checkForceUpdate(){
        forceUpdateUseCase.checkForceUpdate()
    }

}