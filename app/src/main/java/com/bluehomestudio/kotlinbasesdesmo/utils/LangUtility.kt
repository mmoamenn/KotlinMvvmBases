package com.bluehomestudio.kotlinbasesdesmo.utils


import android.app.Activity
import android.content.pm.ActivityInfo
import android.content.pm.PackageManager.NameNotFoundException
import android.content.res.Resources
import android.os.Build

import java.lang.ref.WeakReference
import java.lang.reflect.Field
import kotlin.collections.Map.Entry

import android.content.pm.PackageManager.GET_META_DATA
import android.os.Build.VERSION_CODES.P

object LangUtility {


    fun getPrivateField(className: String, fieldName: String, `object`: Any?): Any? {
        return try {
            val c = Class.forName(className)
            val f = c.getDeclaredField(fieldName)
            f.isAccessible = true
            f.get(`object`)
        } catch (e: Throwable) {
            e.printStackTrace()
            null
        }

    }

    fun resetActivityTitle(a: Activity) {
        try {
            val info = a.packageManager.getActivityInfo(a.componentName, GET_META_DATA)
            if (info.labelRes != 0) {
                a.setTitle(info.labelRes)
            }
        } catch (e: NameNotFoundException) {
            e.printStackTrace()
        }

    }

    fun getTopLevelResources(a: Activity): Resources {
        try {
            return a.packageManager.getResourcesForApplication(a.applicationInfo)
        } catch (e: NameNotFoundException) {
            throw RuntimeException(e)
        }

    }

    fun isAtLeastVersion(version: Int): Boolean {
        return Build.VERSION.SDK_INT >= version
    }
}