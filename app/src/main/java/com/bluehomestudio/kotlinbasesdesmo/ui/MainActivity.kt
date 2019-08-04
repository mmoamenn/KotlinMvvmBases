package com.bluehomestudio.kotlinbasesdesmo.ui

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import com.bluehomestudio.kotlinbasesdesmo.base.BaseActivity
import com.bluehomestudio.kotlinbasesdesmo.utils.PreferenceUtils

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
    }

}
