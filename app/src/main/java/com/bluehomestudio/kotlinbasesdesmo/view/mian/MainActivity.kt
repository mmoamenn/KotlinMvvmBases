package com.bluehomestudio.kotlinbasesdesmo.view.mian

import android.widget.Toast
import androidx.lifecycle.Observer
import com.bluehomestudio.kotlinbasesdesmo.R
import com.bluehomestudio.kotlinbasesdesmo.core.base.BaseActivity
import com.bluehomestudio.kotlinbasesdesmo.data.network.DataStatus
import org.koin.android.viewmodel.ext.android.viewModel


class MainActivity : BaseActivity() {

    override fun getLayout(): Int = R.layout.activity_empty

    private val viewModel: MainViewModel by viewModel()

    override fun init() {
        observers()
    }

    private fun observers() {
        viewModel.checkForceUpdate()
        viewModel.forceUpdateLiveData.observe(this, Observer {
            when (it.status) {
                DataStatus.SUCCESS -> Toast.makeText(this, "SUCCESS", Toast.LENGTH_LONG).show()
                DataStatus.ERROR -> Toast.makeText(this, "ERROR", Toast.LENGTH_LONG).show()
                DataStatus.LOADING -> Toast.makeText(this, "LOADING", Toast.LENGTH_LONG).show()
            }
        })
    }

}

