package com.bluehomestudio.kotlinbasesdesmo.data.network

data class Data<T>(var status: DataStatus, var data: T? = null, var error : Throwable? = null )

enum class DataStatus {
    SUCCESS,
    ERROR,
    LOADING
}