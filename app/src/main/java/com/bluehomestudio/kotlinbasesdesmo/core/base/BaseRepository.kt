package com.bluehomestudio.kotlinbasesdesmo.core.base

import com.bluehomestudio.kotlinbasesdesmo.data.network.NetworkManager
import org.koin.core.KoinComponent
import org.koin.core.inject


abstract class BaseRepository: KoinComponent {

    val network : NetworkManager by inject()

}