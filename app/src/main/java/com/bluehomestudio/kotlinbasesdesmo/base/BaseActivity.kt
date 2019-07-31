package com.bluehomestudio.kotlinbasesdesmo.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import com.bluehomestudio.kotlinbasesdesmo.R
import com.bluehomestudio.kotlinbasesdesmo.utils.easyToast
import com.bluehomestudio.kotlinbasesdesmo.utils.invisible
import com.bluehomestudio.kotlinbasesdesmo.utils.visible
import kotlinx.android.synthetic.main.activity_base.*

abstract class BaseActivity : AppCompatActivity(){

    @LayoutRes abstract fun  getLayout()  : Int

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_base)
        initMainView()
        initLoadingLayout()
    }

    private fun initMainView(){
        vsMainLayout.layoutResource = getLayout()
        vsMainLayout.inflate()
    }

    open fun initLoadingLayout(@LayoutRes loadingLayout : Int = R.layout.view_loading){
        vsLoadingLayout.layoutResource = loadingLayout
        vsLoadingLayout.inflate()
    }

    open fun showLoading(){
        vsLoadingLayout.visible()
    }

    open fun hideLoading(){
        vsLoadingLayout.invisible()
    }

    open fun showError(@StringRes message : Int){
        easyToast(message)
    }

}