package com.bluehomestudio.kotlinbasesdesmo.ui

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import com.bluehomestudio.kotlinbasesdesmo.base.BaseActivity
import com.bluehomestudio.kotlinbasesdesmo.utils.PreferenceUtils
import com.bluehomestudio.kotlinbasesdesmo.utils.isValidEmail

class MainActivity : BaseActivity(){


    override fun getLayout(): Int  = 0

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }

    override fun onStart() {
        super.onStart()
        PreferenceUtils.save("user" , "mohamed moamen11")

        Log.d("prefpref" ,PreferenceUtils.get("user" , "wwqwe"))


        val input = "zcxgedskjdhgjdqs"
        input.isValidEmail()
    }

}

// INTERFACE VALIDATOR {fn is_valid(this){}}
// class EMAIL: validator {FN is_valid(this) {....}}
// fn whatever(inputs: List) {for input in input.is_valid()}