package com.bluehomestudio.kotlinbasesdesmo.data.network

import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route


class Auth() : Authenticator {


    override fun authenticate(route: Route?, response: Response): Request? {

        //asynchronous request to login again or get new token

        return response
            .request()
            .newBuilder()
            .header("authorization", "token")
            .build()
    }

}