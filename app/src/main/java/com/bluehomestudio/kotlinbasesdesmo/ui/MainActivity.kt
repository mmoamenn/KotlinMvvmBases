package com.bluehomestudio.kotlinbasesdesmo.ui

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import com.bluehomestudio.kotlinbasesdesmo.R
import com.bluehomestudio.kotlinbasesdesmo.base.BaseActivity
import com.bluehomestudio.kotlinbasesdesmo.utils.PreferenceUtils
import com.bluehomestudio.kotlinbasesdesmo.utils.isValidEmail

class MainActivity : BaseActivity(){


    override fun getLayout(): Int  = R.layout.activity_empty

    lateinit var viewModel: MainViewModel

    override fun onStart() {
        super.onStart()
        PreferenceUtils.save("user" , "mohamed moamen11")
        Log.d("prefpref" ,PreferenceUtils.get("user" , "wwqwe")!!)
        val input = "zcxgedskjdhgjdqs"
        input.isValidEmail()
    }

}