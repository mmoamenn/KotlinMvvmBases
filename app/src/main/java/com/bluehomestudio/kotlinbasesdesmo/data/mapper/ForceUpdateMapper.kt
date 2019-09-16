package com.bluehomestudio.kotlinbasesdesmo.data.mapper

import com.bluehomestudio.kotlinbasesdesmo.data.response.ForceUpdateResponse
import com.bluehomestudio.kotlinbasesdesmo.domain.model.ForceUpdate

fun ForceUpdateResponse.toForceUpdate() = ForceUpdate( isForceUpdate ,  message)